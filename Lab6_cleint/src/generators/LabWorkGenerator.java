package generators;

import Data.Coordinates;
import Data.Difficulty;
import Data.LabWork;
import Data.Person;
import Exception.*;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class LabWorkGenerator {
    public static LabWork createLabWork() throws WrongInputException{
        LabWork labWork = new LabWork();
        String input;
        long x1;
        long y1;
        Coordinates coordinates;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название: ");
            try {
                input = String.valueOf(scanner.nextLine());
                if (input.isEmpty() | input.equals(null)){
                    throw new WrongInputException();
                }
                labWork.setName(input);
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + scanner.nextLine());
            }
        }

        while (true) {
            System.out.println("Введите координату x");
            try {
                input = scanner.nextLine();
                x1 = Long.parseLong(input);
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        while (true) {
            System.out.println("Введите координату y");
            try {
                input = scanner.nextLine();
                y1 = Long.parseLong(input);
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        coordinates = new Coordinates(0, 0);
        coordinates.setX(x1);
        coordinates.setY(y1);
        labWork.setCoordinates(coordinates);

        while (true){
            System.out.println("Введите минимальную оценку: ");
            try {
                input = scanner.nextLine();
                labWork.setMinimalPoint(Integer.parseInt(input));
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        while (true){
            System.out.println("Введите описание:");
            try {
                input = scanner.nextLine();
                labWork.setDescription(input);
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        while (true){
            System.out.println("Введите среднее значение:");
            try {
                input = scanner.nextLine();
                labWork.setAveragePoint(Long.valueOf(input));
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        while (true){
            System.out.println("Введите сложность:");
            try {
                input = scanner.nextLine();
                labWork.setDifficulty(Difficulty.valueOf(input));
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        Person person = new Person();

        while (true){
            System.out.println("Введите имя");
            try {
                input = scanner.nextLine();
                person.setName(input);
                break;
            } catch (Exception e) {
                System.out.println("Неверный ввод: " + input);
            }
        }

        while (true){
            System.out.println("Введите дату рождения");
            try {
                input = scanner.nextLine();
                person.setBirthday(input);
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        while (true){
            System.out.println("Введите вес");
            try {
                input = scanner.nextLine();
                person.setHeight(Double.valueOf(input));
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        labWork.setAuthor(person);
        return labWork;
    }

    public static LabWork createLabWork(Integer id, String name, Long coordinateX, Long coordinateY,
                                        Integer minimalPoint, String description, Long avaragePoint, Difficulty difficulty,
                                        Person person) throws WrongInputException{
        LabWork labWork = new LabWork();
        labWork.setId(labWork.generateID());
        labWork.setName(name);
        labWork.getCoordinates().setX(coordinateX);
        labWork.getCoordinates().setY(coordinateY);
        labWork.setMinimalPoint(minimalPoint);
        labWork.setDescription(description);
        labWork.setAveragePoint(avaragePoint);
        labWork.setDifficulty(difficulty);
        labWork.setAuthor(person);
        return labWork;
    }
}
