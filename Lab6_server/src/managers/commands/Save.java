package managers.commands;

import managers.CollectionManager;
import managers.FileManagers;
import request.Request;

public class Save implements Command, Command1 {
    CollectionManager collectionManager;

    @Override
    public String execute1(Request request, CollectionManager collectionManager) throws Exception {
        collectionManager.save();
        return "запись в файл успешно произведена";
    }


    @Override
    public String execute(Request request) throws Exception {
        return "";
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "сохраняет коллекцию в файл";
    }
}