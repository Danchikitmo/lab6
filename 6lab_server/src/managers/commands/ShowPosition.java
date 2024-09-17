package managers.commands;

import exceptions.InvalidDataException;
import interfaces.CommandExecutor;
import managers.CollectionManager;

public class ShowPosition extends Command12 implements CommandExecutor {
    CollectionManager collectionManager;
    public ShowPosition(CollectionManager collectionManager) {
        super("show_position");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String args) {
        try {
            Integer index = Integer.parseInt(args.trim());
            collectionManager.showAt(index);
        } catch (InvalidDataException e){
            System.out.println(e.getMessage());
        } catch (NumberFormatException e){
            System.err.println("Это не число формата Integer");
        }
        return args;
    }
}
