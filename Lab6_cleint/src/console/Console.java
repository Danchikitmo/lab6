package console;

import Data.LabWork;
import Manager.ExecuteScriptCommand;
import generators.LabWorkGenerator;
import request.Request;
import server.Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Console {
    private Request request;
    public void start(InputStream inputStream) throws Exception {
        while (true) {
            Scanner scanner = new Scanner(inputStream);
            String input;

            try {
                input = scanner.nextLine();
                request = new Request(input);
                Server server = new Server();

                if(input.equals("add") || input.equals("add_if_min") || input.equals("remove_greater") || input.equals("remove_lower")) {
                    LabWork labWork = LabWorkGenerator.createLabWork();
                    request.setLabWork(labWork);
                } else if(input.split(" ")[0].equals("update")) {
                    String answer = server.senMessage(request);
                    if(answer.equals("wrond_id")) {
                        System.out.println(answer);
                        continue;
                    } else {
                        System.out.println("Давайте создадим новую работу");
                        request.setLabWork(LabWorkGenerator.createLabWork());
                    }
                } else if(input.equals("exit")) {
                    System.exit(1);
                } else if(input.equals("count_greater_than_labWork")) {
                    LabWork labWork = LabWorkGenerator.createLabWork();
                    request.setLabWork(labWork);
                }
                if(input.equals("execute_script_command")) {
                    ExecuteScriptCommand.execute(request.getMessage());
                } else {
                    String echo = server.senMessage(request);
                    System.out.println("Echo from server: \n" + echo);
                    server.close();
                }
            } catch (SocketException e){
                System.err.println("SocketException: \n" + e.getMessage());
            } catch (UnknownHostException e) {
                System.out.println("UnknownHostException: \n" + e.getMessage());
            }
        }
    }
}
