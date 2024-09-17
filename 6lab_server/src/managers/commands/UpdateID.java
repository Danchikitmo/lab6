package managers.commands;

import Data.LabWork;
import managers.CollectionManager;
import managers.commands.Command;


import java.util.Vector;

public class UpdateID implements Command {
    @Override
    public String execute(request.Request request) throws Exception {
        if (request.getMessage().split(" ").length != 2 || !request.getMessage().split(" ")[1].matches("^-{0,1}\\d{1,}") || CollectionManager.getLabWorks().size() == 0 || Long.parseLong(request.getMessage().split(" ")[1]) > CollectionManager.getLabWorks().getLast().getId() || Long.parseLong(request.getMessage().split(" ")[1]) <= 0) {
            return "wrong id";
        } else {
            if (request.getLabWork() == null) {
                return "id is good";
            }

            Long neededId = Long.parseLong(request.getMessage().split(" ")[1]);
            Object[] array = CollectionManager.getLabWorks().toArray();
            LabWork newLabWork = request.getLabWork();
            newLabWork.setId(Math.toIntExact(Long.valueOf(request.getMessage().split(" ")[1])));
            array[(int) (neededId - 1)] = newLabWork;

            Vector<LabWork> updatedVector = new Vector<>();

            for (Object flat : array) {
                updatedVector.add((LabWork) flat);
            }
            CollectionManager.setVector(updatedVector);

            return "Flat successfully update!";
        }
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}