package managers.commands;

import interfaces.CommandExecutor;
import managers.CollectionManager;

public class Save extends Command12 implements CommandExecutor {
    CollectionManager collectionManager;

    public Save(CollectionManager collectionManager){
        super("save");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String args){
        collectionManager.save();
        return args;
    }
}