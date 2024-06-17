package managers.commands;

import interfaces.CommandExecutor;
import managers.CollectionManager;

public class Clear extends Command12 implements CommandExecutor {
    CollectionManager collectionManager;
    public Clear(CollectionManager collectionManager){
        super("clear");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String args){
        collectionManager.clear();
        return args;
    }
}
