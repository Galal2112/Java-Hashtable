package command.hashtable;

import cli.Console;
import hashtable.Hashtable;

public class SearchNumberInHasTable extends HashtableCommand {
    private final static String sCommandName = "Search number in hash table.";

    public SearchNumberInHasTable(Console console, Hashtable hashtable) {
        super(console, hashtable, sCommandName);
    }

    @Override
    public void execute() {
        int key = console.readIntegerFromStdin("Key: ");
        try {
            int hashtableKey = hashtable.search(key);
            System.out.println("Key found: " + hashtableKey);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
