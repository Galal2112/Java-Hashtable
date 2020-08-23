package command.hashtable;

import cli.Console;
import command.ICommand;
import hashtable.Hashtable;

public abstract class HashtableCommand implements ICommand {

    private String commandName;
    protected Hashtable hashtable;
    protected Console console;

    protected HashtableCommand(Console console, Hashtable hashtable, String commandName) {
        this.hashtable = hashtable;
        this.commandName = commandName;
        this.console = console;
    }

    @Override
    public String toString() {
        return commandName;
    }
}
