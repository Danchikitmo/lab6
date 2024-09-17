package managers;

import Data.Works;
import managers.CollectionManager;
import managers.CommandManagers;
import managers.FileManagers;
import managers.commands.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {
    private final CommandManagers commandManager;
    private final CollectionManager collectionManager;
    Scanner scanner = new Scanner(System.in);


    public Input(CommandManagers commandManager, CollectionManager colectionManager) {
        this.commandManager = commandManager;
        this.collectionManager = colectionManager;
    }

    public void listen() throws NoSuchElementException {
        while (true) {
            try {
                String CommandToSplit = (scanner.nextLine().trim() + " ").toLowerCase();
                String[] command = CommandToSplit.split(" ", 2);
                commandManager.execute(command[0], command[1]);
            } catch (NoSuchElementException e) {
                System.err.println("давайте не будем так делать");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addData(){
        String filePath = System.getenv("FILE_PATH");
        Works works = FileManagers.readFile(filePath);
        if (works != null) {
            collectionManager.addToCollection(works.getLabWorks());
        }
    }
}