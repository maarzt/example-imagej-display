/*
 * To the extent possible under law, the ImageJ developers have waived
 * all copyright and related or neighboring rights to this tutorial code.
 *
 * See the CC0 1.0 Universal license for details:
 *     http://creativecommons.org/publicdomain/zero/1.0/
 */

package com.mycompany.imagej;

import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

/**
 * Command that renames a {@link Bird}.
 * This command is shown in the menu under "Example > Name Bird".
 */
@Plugin(type = Command.class, menuPath = "Example > Name Bird")
public class RenameBirdCommand implements Command {

    @Parameter(type = ItemIO.BOTH, label = "Bird")
    private Bird input;

    @Parameter(label = "New name")
    String name;

    @Override
    public void run() {
        input.setName(name);
    }
}
