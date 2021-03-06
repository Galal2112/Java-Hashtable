package command.hashtable;

import cli.Console;
import hashtable.Hashtable;

public class GetNumberFromHashTable extends HashtableCommand {
    private final static String sCommandName = "Get number from hash table.";

    public GetNumberFromHashTable(Console console, Hashtable hashtable) {
        super(console, hashtable, sCommandName);
    }

    @Override
    public void execute() {
        int key = console.readIntegerFromStdin("Key: ");
        try {
            int hashtableKey = hashtable.get(key);
            System.out.println("Key found: " + hashtableKey);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
