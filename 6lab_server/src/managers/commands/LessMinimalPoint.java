package managers.commands;

import interfaces.CommandExecutor;
import managers.CollectionManager;

import java.util.NoSuchElementException;

public class LessMinimalPoint extends Command12 implements CommandExecutor {
    private final CollectionManager collectionManeger;
    public LessMinimalPoint(CollectionManager collectionManager) {
        super("count_less_than_minimal_point");
        this.collectionManeger = collectionManager;
    }
    @Override
    public String execute(String args){
        try {
            if(args.trim().isEmpty()){
                throw new NoSuchElementException("Значение не указано");
            }
            Integer minimalPoint = Integer.parseInt(args.trim());
            collectionManeger.getWorksMinimalPoint(minimalPoint);
        } catch (NumberFormatException e){
            System.err.println("Это не число формата Integer");
        }
        return args;
    }
}
