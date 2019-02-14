package com.mycompany.imagej.biop.ij2demo;

import ij.ImagePlus;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.realtransform.AffineTransform2D;
import org.scijava.command.Command;
import org.scijava.command.CommandService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

@Plugin(type = Command.class, menuPath = "Example > ApplyTwoTimes")
public class ApplyTwoTimesAffineTransform implements Command {

    @Parameter
    ImagePlus imp;

    @Parameter
    AffineTransform2D at2D;

    @Parameter
    CommandService cs;


    @Override
    public void run() {

        cs.run(ApplyAffineTransform.class, true, "at2D", at2D,
                "rai", imp);



    }
}
