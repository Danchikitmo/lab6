import managers.CollectionManager;
import managers.CommandManagers;
import managers.Input;

import java.io.IOException;
import java.net.SocketException;

public class Main {
    public static void main(String[] args) {
        CommandManagers commandManagers = new CommandManagers();
        CollectionManager collectionManager = new CollectionManager();
        Input input = new Input(commandManagers, collectionManager);
        input.addData();
        int port = 1234;
        try {
            Server server = new Server(port);
            server.listen(collectionManager);
        } catch (SocketException e){
            System.err.println("SocketException: " + e.getMessage());
        } catch (IOException e){
            System.err.println("IOException: " + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
