package Manager;

import Data.Coordinates;
import Data.Difficulty;
import Data.LabWork;
import Data.Person;
import request.Request;
import server.Server;
import Exception.*;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Scanner;


public class ExecuteScriptCommand {

    public static void execute(String line) throws Exception {
        Request request = new Request(null);
        String filePath = line.split(" ")[1];

        try {
            Scanner scanner = new Scanner(new FileReader(filePath));
            Server client = new Server();
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                request.setMessage(command);

                if (command.equals("add")) {
                    // Ввод имени LabWork
                    String name = scanner.nextLine();

                    // Ввод координат
                    Long coordinateX = Long.valueOf(scanner.nextLine());
                    Long coordinateY = Long.valueOf(scanner.nextLine());
                    Coordinates coordinates = new Coordinates(coordinateX, coordinateY);

                    // Ввод минимальной оценки
                    Integer minimalPoint = Integer.valueOf(scanner.nextLine());

                    // Ввод описания
                    String description = scanner.nextLine();

                    // Ввод среднего значения
                    Long averagePoint = Long.valueOf(scanner.nextLine());

                    // Ввод сложности
                    Difficulty difficulty = Difficulty.valueOf(scanner.nextLine());

                    // Создание объекта Person (автора LabWork)
                    String birthday = null;
                    Double height = null;
                    String passportID = null;
                    Person author = new Person(name, birthday, height, passportID);

                    // Ввод имени автора
                    String authorName = scanner.nextLine();
                    author.setName(authorName);

                    // Ввод даты рождения автора
                    birthday = scanner.nextLine();
                    author.setBirthday(birthday);

                    // Ввод роста автора
                    height = Double.valueOf(scanner.nextLine());
                    author.setHeight(height);

                    // Ввод паспортного ID автора
                    passportID = scanner.nextLine();
                    author.setPassportID(passportID);

                    // Создание объекта LabWork
                    LabWork labWork = new LabWork();
                    labWork.setName(name);
                    labWork.setCoordinates(coordinates);
                    labWork.setMinimalPoint(minimalPoint);
                    labWork.setDescription(description);
                    labWork.setAveragePoint(averagePoint);
                    labWork.setDifficulty(difficulty);
                    labWork.setAuthor(author);

                    // Генерация и установка времени создания
                    labWork.setCreationDate(ZonedDateTime.now());

                    // Установка сообщения запроса и передачи объекта labWork
                    request.setMessage("add");
                    request.setLabWork(labWork);
                } else if (command.equals("update")) {
                    long neededId = Long.parseLong(scanner.nextLine());
                    LabWork updatedLabWork = createLabWork(scanner);
                    request.setMessage("update " + neededId);
                    request.setLabWork(updatedLabWork);


                } else if (command.equals("exit")) {
                    System.exit(1);

                } else if (command.equals("execute_script " + filePath)) {
                    System.out.println(filePath);
                    throw new WrongInputException();
                }

                System.out.println(client.senMessage(request));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not found");
        } catch (Exception e) {
            System.out.println("Wrong input data");
        }
    }

    /**
     * Создание объекта LabWork из данных, считанных из файла
     */
    private static LabWork createLabWork(Scanner scanner) {
        String name = scanner.nextLine(); // Чтение имени
        double x = Double.parseDouble(scanner.nextLine()); // Чтение координаты X
        double y = Double.parseDouble(scanner.nextLine()); // Чтение координаты Y
        Coordinates coordinates = new Coordinates((long) x, (long) y); // Создание объекта координат

        long minimalPoint = Long.parseLong(scanner.nextLine()); // Чтение минимального балла
        String description = scanner.nextLine(); // Чтение описания
        int averagePoint = Integer.parseInt(scanner.nextLine()); // Чтение среднего балла

        // Чтение сложности, если она есть, иначе устанавливаем null
        Difficulty difficulty = null;
        String difficultyStr = scanner.nextLine();
        if (!difficultyStr.isEmpty()) {
            difficulty = Difficulty.valueOf(difficultyStr);
        }

        // Чтение данных автора
        String authorName = scanner.nextLine();
        LocalDateTime birthday = LocalDateTime.parse(scanner.nextLine()); // Дата рождения
        Double height = null;
        String heightStr = scanner.nextLine();
        if (!heightStr.isEmpty()) {
            height = Double.parseDouble(heightStr);
        }
        String passportID = scanner.nextLine(); // Паспортный ID

        Person author = new Person(authorName, birthday, height, passportID); // Создание объекта автора

        // Создание и возвращение объекта LabWork
        LabWork labWork = new LabWork();
        labWork.setName(name);
        labWork.setCoordinates(coordinates);
        labWork.setCreationDate(ZonedDateTime.from(LocalDateTime.now())); // Дата создания генерируется автоматически
        labWork.setMinimalPoint((int) minimalPoint);
        labWork.setDescription(description);
        labWork.setAveragePoint(averagePoint);
        labWork.setDifficulty(difficulty);
        labWork.setAuthor(author);

        return labWork;
    }

    public String getName() {
        return "execute_script_command";
    }

    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }
}
