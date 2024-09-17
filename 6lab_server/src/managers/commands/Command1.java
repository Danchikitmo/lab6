package managers.commands;

import managers.CollectionManager;
import request.Request;

public interface Command1 {
    public String execute1(Request request, CollectionManager collectionManager) throws Exception;
}
