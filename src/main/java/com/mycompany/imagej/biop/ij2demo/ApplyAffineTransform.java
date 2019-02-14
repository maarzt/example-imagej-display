package com.mycompany.imagej.biop.ij2demo;

import net.imglib2.RandomAccessible;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.RealRandomAccessible;
import net.imglib2.interpolation.randomaccess.NLinearInterpolatorFactory;
import net.imglib2.realtransform.AffineTransform2D;
import net.imglib2.realtransform.RealViews;
import net.imglib2.view.ExtendedRandomAccessibleInterval;
import net.imglib2.view.Views;
import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

@Plugin(type = Command.class, menuPath = "Example > Apply AffineTransform")
public class ApplyAffineTransform implements Command {

    @Parameter(type = ItemIO.INPUT)
    RandomAccessibleInterval rai;

    @Parameter(type = ItemIO.INPUT)
    AffineTransform2D at2D;

    @Parameter(type = ItemIO.OUTPUT)
    RandomAccessibleInterval transformedrai;

    @Override
    public void run() {
        ExtendedRandomAccessibleInterval extended = Views.extendZero(rai);
        RealRandomAccessible field = Views.interpolate(extended, new NLinearInterpolatorFactory());
        RandomAccessible transformed = RealViews.affine(field, at2D);
        transformedrai = Views.interval(transformed,rai);
    }
}
