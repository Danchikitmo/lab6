package managers.commands;

import managers.CommandManagers;
import request.Request;

import java.util.HashMap;

public class Help implements Command {

    @Override
    public String execute(Request request) throws Exception {
        StringBuilder line = new StringBuilder();
        HashMap<String, Command> command1Vector = CommandManagers.getCommandList();
        for(String name: command1Vector.keySet()){
            Command command1 = command1Vector.get(name);
            line.append(command1.getName()).append(" -- ").append(command1.getDescription()).append("\n");
        }

        line.append("execute_script_command").append(" -- ").append("считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режим");
        return line.toString();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Вывести справку по достпуным командам";
    }
}