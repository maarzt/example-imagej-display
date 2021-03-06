/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2009 - 2016 Board of Regents of the University of
 * Wisconsin-Madison, Broad Institute of MIT and Harvard, and Max Planck
 * Institute of Molecular Cell Biology and Genetics.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package net.imagej.ui.swing.viewer.bird;

import com.mycompany.imagej.Bird;
import net.imagej.ui.swing.viewer.EasySwingDisplayViewer;
import net.miginfocom.swing.MigLayout;
import org.scijava.Context;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.ui.viewer.DisplayViewer;

import javax.swing.*;
import java.awt.*;

/**
 * This class is responsible for displaying the {@link Bird}.
 */
@Plugin(type = DisplayViewer.class) public class SwingBirdDisplayViewer
		extends EasySwingDisplayViewer< Bird >
{

	@Parameter Context context;

	/**
	 * Keeps a reference to the {@link Bird} that is displayed.
	 */
	private Bird bird = null;

	/**
	 * Label that is used to show the name of the {@link Bird}.
	 */
	JLabel labelName;

	public SwingBirdDisplayViewer()
	{
		super(Bird.class);
	}

	@Override protected boolean canView(Bird bird)
	{
		return true;
	}

	@Override protected JPanel createDisplayPanel(Bird bird)
	{
		System.out.println(
				"JPanel required for object " + bird + " in context " +
						context + ".");
		this.bird = bird;
		final JPanel panel = new JPanel();
		panel.setLayout(new MigLayout());
		final JLabel labelKind = new JLabel("Bird: " + bird.getKind());
		labelKind.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		panel.add(labelKind, "wrap");
		labelName = new JLabel(bird.getName());
		labelName.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		panel.add(labelName);
		return panel;
	}

	/**
	 * Called each time the {@link Bird} is output of a command.
	 * ({@code @Parameter(type = ItemIO.OUTPUT)} or {@code @Parameter(type = ItemIO.BOTH)})
	 */
	@Override public void redraw()
	{
		labelName.setText(bird.getName());
		getWindow().pack();
	}

	@Override public void redoLayout()
	{
		// ignored
	}

	@Override public void setLabel(final String s)
	{
		// ignored
	}
}
