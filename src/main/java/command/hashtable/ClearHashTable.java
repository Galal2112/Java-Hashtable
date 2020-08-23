package command.hashtable;

import cli.Console;
import hashtable.Hashtable;

public class ClearHashTable extends HashtableCommand {
    private final static String sCommandName = "Clear hash table.";

    public ClearHashTable(Console console, Hashtable hashtable) {
        super(console, hashtable, sCommandName);
    }

    @Override
    public void execute() {
        hashtable.clear();
        System.out.println("Hash table cleared");
    }
}
