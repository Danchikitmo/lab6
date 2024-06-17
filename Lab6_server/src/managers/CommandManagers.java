package managers;

import managers.commands.*;
import request.Request;


import java.util.LinkedHashMap;

public class CommandManagers {
    private static final LinkedHashMap<String, Command> commands = new LinkedHashMap<>();

    public CommandManagers(){
        commands.put("help", new Help());
        commands.put("show", new Show());
        commands.put("info", new Info());
    }



    public void execute(String name, String args) throws Exception {
        Command command = commands.get(name);
        if(command == null){
            System.err.println("Такой команды нет");
        } else {
            System.out.println("Команда " + name + " выполнена");
        }
    }

    public static String startExecuting(Request request) throws Exception{
        String commandName = request.getMessage().split(" ")[0];
        if(!commands.containsKey(commandName)){
            return "Неизвестная команда";
        }
        Command command = commands.get(commandName);
        return command.execute(request);
    }

    public static LinkedHashMap<String, Command> getCommandList(){
        return commands;
    }
}
