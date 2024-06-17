package managers.commands;

import Data.LabWork;

import java.util.Vector;

public class Command12 implements LabWorkCommand{
    private final String name;
    public Command12(String name){
        this.name = name;
    }

    @Override
    public String execute(String args){
        System.out.println("Команда " + name + " успешно выполнена");
        return args;
    }

    @Override
    public void execute(Vector<LabWork> labWorks){
        System.out.println("123");
    }


    public String getName(){
        return name;
    }
}
