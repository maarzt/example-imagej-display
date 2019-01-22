package net.imagej.ui.swing.viewer.simple;

import com.mycompany.imagej.Bird;
import net.imagej.ui.swing.viewer.parrot.SwingBirdDisplayPanel;
import org.scijava.display.Display;
import org.scijava.display.event.DisplayDeletedEvent;
import org.scijava.object.ObjectService;
import org.scijava.plugin.Parameter;
import org.scijava.ui.UserInterface;
import org.scijava.ui.swing.SwingUI;
import org.scijava.ui.viewer.AbstractDisplayViewer;
import org.scijava.ui.viewer.DisplayViewer;
import org.scijava.ui.viewer.DisplayWindow;

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
		final SwingBirdDisplayPanel panel = createDisplayPanel( getDisplay().get(0) );
		panel.setDisplay( d );
		panel.setWindow( w );
		setPanel( panel );
	}

	protected abstract SwingBirdDisplayPanel createDisplayPanel(T value);
}
