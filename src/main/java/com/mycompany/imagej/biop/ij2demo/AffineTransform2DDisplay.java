package com.mycompany.imagej.biop.ij2demo;

import net.imglib2.realtransform.AffineTransform2D;
import org.scijava.display.AbstractDisplay;
import org.scijava.display.Display;
import org.scijava.plugin.Plugin;

@Plugin(type = Display.class)
public class AffineTransform2DDisplay extends AbstractDisplay<AffineTransform2D> {

    public AffineTransform2DDisplay() {
        super(AffineTransform2D.class);
    }
}
