package managers.commands;

import interfaces.CommandExecutor;
import managers.CollectionManager;

import java.util.NoSuchElementException;

public class RemoveByID extends Command12 implements CommandExecutor {
    CollectionManager collectionManager;
    public RemoveByID(CollectionManager collectionManager){
        super("remove_by_id");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String args){
        try {
            Integer id = Integer.parseInt(args.trim());
            collectionManager.removeElement(collectionManager.getPersonById(id));
            System.out.println("Удаление человка прошло успешно");
        } catch (NoSuchElementException e){
            System.err.println("Нет такого человека в коллекции");
        } catch (NumberFormatException e){
            System.err.println("Это не число формата Integer");
        }
        return args;
    }
}
