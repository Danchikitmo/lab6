package managers.commands;

import exceptions.EmptyCollectionException;
import interfaces.CommandExecutor;
import managers.CollectionManager;

public class RemoveFirst extends Command12 implements CommandExecutor {
    CollectionManager collectionManager;
    public RemoveFirst(CollectionManager collectionManager){
        super("remove_first");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String args){
        try {
            collectionManager.removeFirst();
            System.out.println("Удаление человка прошло успешно");
        } catch (EmptyCollectionException e){
            System.err.println("Коллекция пуста");
        }
        return args;
    }
}
