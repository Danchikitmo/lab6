package Manager;

import Data.Coordinates;
import Data.Difficulty;
import Data.LabWork;
import Data.Person;
import request.Request;
import server.Server;
import Exception.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class ExecuteScriptCommand {
    public static void  execute(String line) throws Exception{
        Request request = new Request(null);
        String filePath = line.split(" ")[1];

        try {
            Scanner scanner = new Scanner(new File(filePath));
            Server client = new Server();
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                request.setMessage(command);

                if (command.equals("add")) {
                    String name = scanner.nextLine();
                    Long coordinatesX = Long.valueOf(scanner.nextLine());
                    Long cordinatesY = Long.valueOf(scanner.nextLine());
                    Coordinates coordinates = new Coordinates(coordinatesX, cordinatesY);
                    Integer minimalPoints = Integer.valueOf(scanner.nextLine());
                    String description = scanner.nextLine();
                    Long averagePoints = Long.valueOf(scanner.nextLine());
                    Difficulty difficulty = Difficulty.valueOf(scanner.nextLine());

                    Person person = new Person();

                    String namePerson = scanner.nextLine();
                    ZonedDateTime birthDate = ZonedDateTime.parse(scanner.nextLine());
                    Double height = Double.valueOf(scanner.nextLine());

                    person.setName(namePerson);
                    person.setBirthday(String.valueOf(birthDate));
                    person.setHeight(height);

                    LabWork labWork = new LabWork();
                    labWork.setName(name);
                    labWork.setCoordinates(coordinates);
                    labWork.setMinimalPoint(minimalPoints);
                    labWork.setDescription(description);
                    labWork.setAveragePoint(averagePoints);
                    labWork.setDifficulty(difficulty);

                    request.setMessage("add");
                    request.setLabWork(labWork);
                } else if (command.equals("update")) {
                    Integer nededId = Integer.valueOf(scanner.nextLine());
                    String name = scanner.nextLine();
                    Long coordinatesX = Long.valueOf(scanner.nextLine());
                    Long cordinatesY = Long.valueOf(scanner.nextLine());
                    Coordinates coordinates = new Coordinates(coordinatesX, cordinatesY);
                    Integer minimalPoints = Integer.valueOf(scanner.nextLine());
                    String description = scanner.nextLine();
                    Long averagePoints = Long.valueOf(scanner.nextLine());
                    Difficulty difficulty = Difficulty.valueOf(scanner.nextLine());

                    Person person = new Person();

                    String namePerson = scanner.nextLine();
                    ZonedDateTime birthDate = ZonedDateTime.parse(scanner.nextLine());
                    Double height = Double.valueOf(scanner.nextLine());

                    person.setName(namePerson);
                    person.setBirthday(String.valueOf(birthDate));
                    person.setHeight(height);

                    LabWork labWork = new LabWork();
                    labWork.setName(name);
                    labWork.setCoordinates(coordinates);
                    labWork.setMinimalPoint(minimalPoints);
                    labWork.setDescription(description);
                    labWork.setAveragePoint(averagePoints);
                    labWork.setDifficulty(difficulty);

                    request.setMessage("update " + nededId);
                    request.setLabWork(labWork);
                } else if (command.equals("add_if_min")) {
                    String name = scanner.nextLine();
                    Long coordinatesX = Long.valueOf(scanner.nextLine());
                    Long cordinatesY = Long.valueOf(scanner.nextLine());
                    Coordinates coordinates = new Coordinates(coordinatesX, cordinatesY);
                    Integer minimalPoints = Integer.valueOf(scanner.nextLine());
                    String description = scanner.nextLine();
                    Long averagePoints = Long.valueOf(scanner.nextLine());
                    Difficulty difficulty = Difficulty.valueOf(scanner.nextLine());

                    Person person = new Person();

                    String namePerson = scanner.nextLine();
                    ZonedDateTime birthDate = ZonedDateTime.parse(scanner.nextLine());
                    Double height = Double.valueOf(scanner.nextLine());

                    person.setName(namePerson);
                    person.setBirthday(String.valueOf(birthDate));
                    person.setHeight(height);

                    LabWork labWork = new LabWork();
                    labWork.setName(name);
                    labWork.setCoordinates(coordinates);
                    labWork.setMinimalPoint(minimalPoints);
                    labWork.setDescription(description);
                    labWork.setAveragePoint(averagePoints);
                    labWork.setDifficulty(difficulty);

                    request.setMessage("add_if_min");
                    request.setLabWork(labWork);
                } else if (command.equals("remove_greater")) {
                    String name = scanner.nextLine();
                    Long coordinatesX = Long.valueOf(scanner.nextLine());
                    Long cordinatesY = Long.valueOf(scanner.nextLine());
                    Coordinates coordinates = new Coordinates(coordinatesX, cordinatesY);
                    Integer minimalPoints = Integer.valueOf(scanner.nextLine());
                    String description = scanner.nextLine();
                    Long averagePoints = Long.valueOf(scanner.nextLine());
                    Difficulty difficulty = Difficulty.valueOf(scanner.nextLine());

                    Person person = new Person();

                    String namePerson = scanner.nextLine();
                    ZonedDateTime birthDate = ZonedDateTime.parse(scanner.nextLine());
                    Double height = Double.valueOf(scanner.nextLine());

                    person.setName(namePerson);
                    person.setBirthday(String.valueOf(birthDate));
                    person.setHeight(height);

                    LabWork labWork_param = new LabWork();
                    labWork_param.setName(name);
                    labWork_param.setCoordinates(coordinates);
                    labWork_param.setMinimalPoint(minimalPoints);
                    labWork_param.setDescription(description);
                    labWork_param.setAveragePoint(averagePoints);
                    labWork_param.setDifficulty(difficulty);

                    request.setLabWork(labWork_param);
                    request.setMessage("remove_greater");
                } else if (command.equals("remove_lower")) {
                    String name = scanner.nextLine();
                    Long coordinatesX = Long.valueOf(scanner.nextLine());
                    Long cordinatesY = Long.valueOf(scanner.nextLine());
                    Coordinates coordinates = new Coordinates(coordinatesX, cordinatesY);
                    Integer minimalPoints = Integer.valueOf(scanner.nextLine());
                    String description = scanner.nextLine();
                    Long averagePoints = Long.valueOf(scanner.nextLine());
                    Difficulty difficulty = Difficulty.valueOf(scanner.nextLine());

                    Person person = new Person();

                    String namePerson = scanner.nextLine();
                    ZonedDateTime birthDate = ZonedDateTime.parse(scanner.nextLine());
                    Double height = Double.valueOf(scanner.nextLine());

                    person.setName(namePerson);
                    person.setBirthday(String.valueOf(birthDate));
                    person.setHeight(height);

                    LabWork labWork_param = new LabWork();
                    labWork_param.setName(name);
                    labWork_param.setCoordinates(coordinates);
                    labWork_param.setMinimalPoint(minimalPoints);
                    labWork_param.setDescription(description);
                    labWork_param.setAveragePoint(averagePoints);
                    labWork_param.setDifficulty(difficulty);

                    request.setLabWork(labWork_param);
                    request.setMessage("remove_lower");
                } else if (command.equals("exit")) {
                    System.exit(1);
                } else if (command.equals("execute_script_command " + filePath)) {
                    throw new WrongInputException();
                }
                System.out.println(client.senMessage(request));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        } catch (Exception e){
            System.err.println("Wrong input data");
        }
    }

    public String getName(){
        return "execute_script_command";
    }

    public String getDescription(){
        return "считать и исполнить скрипт из указанного файла. В скрипте содержаться в таком же виде, в котором их вводит ползователь";
    }
}