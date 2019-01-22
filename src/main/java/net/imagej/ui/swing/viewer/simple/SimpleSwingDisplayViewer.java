package net.imagej.ui.swing.viewer.simple;

import net.imagej.ui.swing.viewer.parrot.SwingBirdDisplayViewer;
import org.scijava.display.Display;
import org.scijava.display.event.DisplayDeletedEvent;
import org.scijava.object.ObjectService;
import org.scijava.plugin.Parameter;
import org.scijava.ui.UserInterface;
import org.scijava.ui.swing.SwingUI;
import org.scijava.ui.viewer.AbstractDisplayViewer;
import org.scijava.ui.viewer.DisplayPanel;
import org.scijava.ui.viewer.DisplayViewer;
import org.scijava.ui.viewer.DisplayWindow;

import javax.swing.*;

abstract public class SimpleSwingDisplayViewer<T> extends
		AbstractDisplayViewer<T> implements DisplayViewer<T>
{
	private final Class<?> type;

	@Parameter
	ObjectService objectService;

	protected SimpleSwingDisplayViewer( Class< ? > type )
	{
		this.type = type;
	}

	@Override
	public boolean isCompatible(final UserInterface ui) {
		return ui instanceof SwingUI;
	}

	@Override
	public boolean canView(final Display<?> d) {
		Object object = d.get( 0 );
		if(! type.isInstance( object ) )
			return false;
		T value = ( T ) object;
		return canView( value );
	}

	protected abstract boolean canView( T value );

	@Override
	public void onDisplayDeletedEvent( DisplayDeletedEvent e )
	{
		super.onDisplayDeletedEvent( e );
		objectService.removeObject( getDisplay().get( 0 ) );
	}

	@Override
	public void view(final DisplayWindow w, final Display<?> d) {
		objectService.addObject( d.get( 0 ) );
		super.view(w, d);
		final SwingBirdDisplayViewer.SwingBirdDisplayPanel panel = createDisplayPanel( getDisplay().get(0) );
		panel.setDisplay( d );
		panel.setWindow( w );
		setPanel( panel );
	}

	protected abstract SwingBirdDisplayViewer.SwingBirdDisplayPanel createDisplayPanel(T value);

	abstract public static class Panel extends JPanel implements DisplayPanel
	{

		// -- instance variables --

		private DisplayWindow window;
		private Display< ? > display;

		// -- PlotDisplayPanel methods --

		public void setWindow( DisplayWindow window )
		{
			this.window = window;
			window.setContent(this);
		}

		public void setDisplay( Display< ? > display )
		{
			this.display = display;
		}

		@Override
		public Display< ? > getDisplay() {
			return display;
		}

		// -- DisplayPanel methods --

		@Override
		public DisplayWindow getWindow() {
			return window;
		}
	}
}
