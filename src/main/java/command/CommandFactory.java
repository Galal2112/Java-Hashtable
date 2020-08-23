package command;

import cli.Console;
import command.hashtable.*;
import hashtable.Hashtable;
import sort.BubbleSort;
import sort.HeapSort;
import sort.QuickSort;
import sort.SelectionSort;

import java.util.LinkedList;

public class CommandFactory {

    public static LinkedList<ICommand> createAppCommendList(Console console, Hashtable hashtable) {
        LinkedList<ICommand> commands = new LinkedList<>();
        commands.add(new AddNumberToHashTable(console, hashtable));
        commands.add(new GetNumberFromHashTable(console, hashtable));
        commands.add(new SearchNumberInHasTable(console, hashtable));
        commands.add(new DeleteNumberFromHashTable(console, hashtable));
        commands.add(new ClearHashTable(console, hashtable));
        commands.add(new SortStudentsByMatriculationNumber(console));
        return commands;
    }

    public static LinkedList<ICommand> getAvailableStudentMarticulationSortCommands() {
        LinkedList<ICommand> commands = new LinkedList<>();
        commands.add(new SortStudentAlgoCommand(new SelectionSort<>()));
        commands.add(new SortStudentAlgoCommand(new HeapSort<>()));
        commands.add(new SortStudentAlgoCommand(new BubbleSort<>()));
        commands.add(new SortStudentAlgoCommand(new QuickSort<>()));
        return commands;
    }

}
