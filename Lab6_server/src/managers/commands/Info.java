package managers.commands;

import managers.CollectionManager;
import request.Request;

public class Info implements Command {

    @Override
    public String execute(Request request) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Тип -- " + CollectionManager.getLabWorks().getClass().getName() + "\n");
        stringBuilder.append("Количество работ -- " + CollectionManager.getLabWorks().size() + "\n");
        stringBuilder.append("Дата инициализации -- " + CollectionManager.getInitDate() + "\n");
        return stringBuilder.toString();
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
