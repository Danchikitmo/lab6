package managers.commands;

import request.Request;

public interface Command {
    public String execute(Request request) throws Exception;
    public String getName();
    public String getDescription();
}
