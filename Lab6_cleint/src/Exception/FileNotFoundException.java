package Exception;

public class FileNotFoundException extends Exception{
    public FileNotFoundException(){
        System.err.println("Файл не найден");
    }
}
