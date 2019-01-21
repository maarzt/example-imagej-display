package net.imagej.ui.swing.viewer.simple;

import com.mycompany.imagej.Bird;
import org.scijava.display.Display;
import org.scijava.ui.viewer.DisplayPanel;
import org.scijava.ui.viewer.DisplayWindow;

import javax.swing.*;

abstract public class SimpleSwingDisplayPanel extends JPanel implements DisplayPanel
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
