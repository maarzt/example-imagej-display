/*
 * To the extent possible under law, the ImageJ developers have waived
 * all copyright and related or neighboring rights to this tutorial code.
 *
 * See the CC0 1.0 Universal license for details:
 *     http://creativecommons.org/publicdomain/zero/1.0/
 */

package com.mycompany.imagej;

import net.imagej.ImageJ;
import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

/**
 * Command that allows to create a {@link Bird}.
 * This command is shown in the menu under "Example > New Bird".
 */
@Plugin(type = Command.class, menuPath = "Example > New Bird")
public class NewBirdCommand implements Command {

	@Parameter(choices = { "Parrot", "Owl", "Kiwi" }) private String kind;

	@Parameter(type = ItemIO.OUTPUT) private Bird output;

	@Override public void run() {
		output = new Bird(kind);
	}

	/**
	 * This main function serves for development purposes.
	 * It allows you to run the plugin immediately out of
	 * your integrated development environment (IDE).
	 *
	 * @param args whatever, it's ignored
	 * @throws Exception
	 */
	public static void main(final String... args) throws Exception {
		// create the ImageJ application context with all available services
		final ImageJ ij = new ImageJ();
		ij.ui().showUI();
		ij.command().run(NewBirdCommand.class, true);
	}

}
