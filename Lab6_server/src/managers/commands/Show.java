package managers.commands;

import Data.LabWork;
import managers.CollectionManager;
import request.Request;

import java.util.Vector;

public class Show implements Command {



    @Override
    public String execute(Request request) throws Exception {
        Vector<LabWork> labWorks = CollectionManager.getLabWorks();
        StringBuilder stringBuilder = new StringBuilder();
        if(labWorks.isEmpty()){
            return "Коллекция пуста";
        } else {
            for(LabWork labWork: labWorks){
                stringBuilder.append(labWork+ "\n");
            }
            return stringBuilder.toString();
        }
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
