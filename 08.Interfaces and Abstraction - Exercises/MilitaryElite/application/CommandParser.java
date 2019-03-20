package MilitaryElite.application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandParser {
    private List<String> commandsWithTokens;
    private Command command;

    public CommandParser(List<String> commandsWithTokens) {
        this.commandsWithTokens = commandsWithTokens;
        this.command = new Command();
    }

    public Army parseCommands() {
        for (String commandLine : this.commandsWithTokens) {
            String[] commandTokens = commandLine.split("\\s+");
                this.command.execute(commandTokens[0], Arrays.stream(commandTokens)
                    .skip(1).collect(Collectors.toList()));
        }
        return this.command.getARMY();
    }
}
