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

package net.imagej.ui.swing.viewer.parrot;

import com.mycompany.imagej.Bird;
import net.imagej.ui.swing.viewer.simple.SimpleSwingDisplayViewer;
import org.scijava.plugin.Plugin;
import org.scijava.ui.viewer.DisplayViewer;

import javax.swing.*;
import java.awt.*;

@Plugin(type = DisplayViewer.class)
public class SwingBirdDisplayViewer extends
		SimpleSwingDisplayViewer<Bird>
{

	public SwingBirdDisplayViewer()
	{
		super( Bird.class );
	}

	@Override
	protected boolean canView( Bird bird )
	{
		return true;
	}

	@Override
	protected SwingBirdDisplayPanel createDisplayPanel( Bird bird )
	{
		return new SwingBirdDisplayPanel( bird );
	}

	public static class SwingBirdDisplayPanel extends SimpleSwingDisplayViewer.Panel
	{

		// -- constructor --

		public SwingBirdDisplayPanel( final Bird bird )
		{
			setLayout(new BorderLayout());
			final JLabel label = new JLabel( bird.toString() );
			label.setFont(new Font( Font.SERIF, Font.BOLD, 30 ));
			add( label );
		}

		@Override
		public void redoLayout()
		{

		}

		@Override
		public void setLabel(final String s) {

		}

		@Override
		public void redraw()
		{

		}
	}
}
