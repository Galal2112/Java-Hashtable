package command.hashtable;

import cli.Console;
import command.CommandFactory;
import command.CommandInvoker;
import command.ICommand;

import java.util.LinkedList;

public class SortStudentsByMatriculationNumber implements ICommand {

    private final static String sCommandName = "Sort students by matriculation number.";
    private Console console;

    public SortStudentsByMatriculationNumber(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        LinkedList<ICommand> commands = CommandFactory.getAvailableStudentMarticulationSortCommands();
        CommandInvoker invoker = new CommandInvoker(commands, console, "", false);
        invoker.run();
    }

    @Override
    public String toString() {
        return sCommandName;
    }
}
