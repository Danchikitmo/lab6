package managers.commands;

import Data.LabWork;
import managers.CollectionManager;
import request.Request;

public class Add implements Command {

    @Override
    public String execute(Request request) throws Exception {
        LabWork labWork = request.getLabWork();
        labWork.setId(labWork.generateID());
        CollectionManager.add(labWork);

        return "Работа добавлена";
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию";
    }
}
