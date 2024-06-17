package Exception;

public class UnknownCommandException extends Exception{
    public UnknownCommandException(String message){
        super("Неизвестная команда: " + message);
    }
}
