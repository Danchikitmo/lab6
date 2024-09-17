package managers.commands;

import builder.LabWorkBuilder;
import exceptions.InvalidDataException;
import interfaces.CommandExecutor;
import managers.CollectionManager;

public class InsertAt extends Command12 implements CommandExecutor {
    CollectionManager collectionManager;
    public InsertAt(CollectionManager collectionManager) {
        super("insert_at");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String args) {
        Integer index = Integer.parseInt(args.trim());
        try {
            collectionManager.insertAt(index, new LabWorkBuilder().create());
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e){
            System.err.println("Это не число формата Integer");
        }
        return args;
    }
}

