package managers.commands;

public class Exit extends Command12 {
    public Exit(){
        super("exit");
    }

    @Override
    public String execute(String args){
        System.out.println("Завершение программы");
        System.exit(1);
        return args;
    }
}
