package managers.commands;

import exceptions.InvalidDataException;
import interfaces.CommandExecutor;
import managers.CollectionManager;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class UpdateID extends Command12 implements CommandExecutor {
    public static boolean isFromFile = false;
    private final CollectionManager collectionManager;
    private Scanner method;

    public UpdateID(CollectionManager collectionManager){
        super("update_id");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String args){
        try {
            if(args.trim().isEmpty()){
                throw new NoSuchElementException("Индентификатор не указан");
            }
            Integer id = Integer.parseInt(args.trim());
            collectionManager.updateID(id);
        } catch (NoSuchElementException e) {
            System.err.println("Нет человек с таким id ");
        } catch (InvalidDataException e){
            System.err.println("Что-то не так с данными");
        } catch (NumberFormatException e){
            System.err.println("Это не число формата Integer");
        }
        return args;
    }
}
