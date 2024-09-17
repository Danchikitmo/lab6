package managers.commands;

import managers.CollectionManager;
import managers.CommandManagers;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class ExecuteScript extends Command12 {
    private final CollectionManager collectionManager;
    private final CommandManagers commandManagers;
    public  static  boolean isFromFile = false;

    private final Set<String> executeScript = new HashSet<>();

    public ExecuteScript(CollectionManager colectionManager, CommandManagers commandManagers){
        super("execute_script");
        this.collectionManager = colectionManager;
        this.commandManagers = commandManagers;
    }

    @Override
    public String execute(String args){
        try {
            isFromFile = true;
            if(args.trim().isEmpty()){
                throw new NoSuchElementException("Идентификатор не указан");
            }

            String filePath = System.getenv("FILE_PATH") + args.trim();
            collectionManager.executeScript(filePath, commandManagers, executeScript);
            isFromFile = false;
        } catch (NullPointerException e){
            System.err.println("Вы не указали имя файла");
        }
        return args;
    }
}