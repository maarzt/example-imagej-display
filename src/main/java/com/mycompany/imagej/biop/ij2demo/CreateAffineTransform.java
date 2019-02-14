package com.mycompany.imagej.biop.ij2demo;
import net.imglib2.realtransform.AffineTransform2D;
import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.object.ObjectService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

@Plugin(type = Command.class, menuPath = "Example > New AffineTransform")
public class CreateAffineTransform implements Command {

    @Parameter
    private double scaleX;

    @Parameter
    private double scaleY;

    @Parameter
    private double skewX;

    @Parameter
    private double skewY;

    @Parameter(type = ItemIO.OUTPUT)
    AffineTransform2D at2D;


    @Override
    public void run() {
        at2D = new AffineTransform2D();
        double[][] m = {
                {scaleX,skewY,0},
                {skewX,scaleY,0},
                {0,0,0}};
        at2D.set(m);
    }
}
