package command;

import cli.Console;
import command.system.ExitCmd;

import java.util.LinkedList;

public class CommandInvoker {
    private final transient LinkedList<ICommand> commands;
    private final transient Console console;
    private final transient String headline;
    private final transient boolean addExit;
    private final ExitCmd exitCmd = new ExitCmd();

    public CommandInvoker(LinkedList<ICommand> commands, Console console, String programHeadline, boolean addExit) {
        super();
        this.commands = commands;
        this.console = console;
        this.headline = programHeadline;
        this.addExit = addExit;
    }

    public void run() {
        do {
            if (!headline.isEmpty()) {
                System.out.println(headline + System.lineSeparator());
            }
            printCommandLineMenu();
            ICommand cmd = selectCommandByCommandLine();
            System.out.println(System.lineSeparator() + ">>> " + cmd + " <<<" + System.lineSeparator());
            cmd.execute();
            System.out.println(System.lineSeparator());
            if (!addExit) {
                return;
            }
        } while (true);
    }

    private void printCommandLineMenu() {
        for (int i = 0; i < commands.size(); i++) {
            printCommandLine(i);
        }
        if (addExit) {
            System.out.println(" " + 0 + ". " + exitCmd);
        }
    }

    private void printCommandLine(int i) {
        System.out.println(" " + (i + 1) + ". " + commands.get(i));
    }

    private ICommand selectCommandByCommandLine() {
        do {
            int index = console.readIntegerFromStdin(System.lineSeparator() + "Please enter an option: ");
            int min = addExit ? 0 : 1;
            if (isValidOption(index, min, commands.size())) {
                if (index == 0) {
                    return exitCmd;
                }
                return commands.get(index - 1);
            }
        } while (true);
    }

    private boolean isValidOption(int x, int min, int max) {
        return x >= min && x <= max;
    }
}
