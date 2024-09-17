package managers.commands;

import Data.LabWork;
import interfaces.CommandExecutor;
import managers.CollectionManager;
import request.Request;

import java.util.NoSuchElementException;
import java.util.Vector;

public class RemoveByID implements Command {

    @Override
    public String execute(Request request) throws Exception {
        if (request.getMessage().split(" ").length != 2 || !request.getMessage().split(" ")[1].matches("^-{0,1}\\d{1,}") || CollectionManager.getLabWorks().size() == 0 || Long.parseLong(request.getMessage().split(" ")[1]) > CollectionManager.getLabWorks().getLast().getId() || Long.parseLong(request.getMessage().split(" ")[1]) <= 0) {
            return "wrong id";
        } else {
            Integer neededID = Integer.parseInt(request.getMessage().split(" ")[1]);
            Object[] array = CollectionManager.getLabWorks().toArray();

            Vector<LabWork> updateVector = new Vector<>();

            for (Object object : array) {
                LabWork labWork = (LabWork) object;
                if (labWork.getId() != neededID) {
                    updateVector.add(labWork);
                }
            }
            CollectionManager.setVector(updateVector);
            return "Работа успешно удалена";

        }
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его id";
    }
}
