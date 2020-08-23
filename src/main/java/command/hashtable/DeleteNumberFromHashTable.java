package command.hashtable;

import cli.Console;
import hashtable.Hashtable;

public class DeleteNumberFromHashTable extends HashtableCommand {
    private final static String sCommandName = "Delete number from hash table.";

    public DeleteNumberFromHashTable(Console console, Hashtable hashtable) {
        super(console, hashtable, sCommandName);
    }

    @Override
    public void execute() {
        int key = console.readIntegerFromStdin("Key: ");
        try {
            hashtable.remove(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
