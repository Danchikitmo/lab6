package managers.commands;

import interfaces.CommandExecutor;
import managers.CollectionManager;
import request.Request;

public class Clear implements Command {


    @Override
    public String execute(Request request) throws Exception {
        CollectionManager.clear();
        return "Удаление произошло успешно";
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "очистка коллекции";
    }
}
