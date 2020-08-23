package command.hashtable;

import cli.Console;
import hashtable.Hashtable;

public class AddNumberToHashTable extends HashtableCommand {
    private final static String sCommandName = "Add number to hash table.";

    public AddNumberToHashTable(Console console, Hashtable hashtable) {
        super(console, hashtable, sCommandName);
    }

    @Override
    public void execute() {
        int key = console.readIntegerFromStdin("Key: ");
        try {
            hashtable.insert(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
