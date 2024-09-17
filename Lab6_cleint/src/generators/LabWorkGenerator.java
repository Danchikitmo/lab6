package generators;

import Data.Coordinates;
import Data.Difficulty;
import Data.LabWork;
import Data.Person;
import Exception.*;

import java.time.LocalDate;
import java.util.Scanner;

public class LabWorkGenerator {
    public static LabWork createLabWork() throws WrongInputException {
        LabWork labWork = new LabWork();
        String input;
        long x1;
        long y1;
        Coordinates coordinates;
        String name;
        String birthday;
        Double height;
        String passportID;
        Person person;
        Scanner scanner = new Scanner(System.in);

        // Ввод имени LabWork
        while (true) {
            System.out.println("Введите название: ");
            try {
                input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new WrongInputException();
                }
                labWork.setName(input);
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: ");
            }
        }

        // Ввод координат X и Y
        while (true) {
            System.out.println("Введите координату x:");
            try {
                input = scanner.nextLine();
                x1 = Long.parseLong(input);
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        while (true) {
            System.out.println("Введите координату y:");
            try {
                input = scanner.nextLine();
                y1 = Long.parseLong(input);
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        coordinates = new Coordinates(x1, y1);
        labWork.setCoordinates(coordinates);

        // Ввод минимальной оценки
        while (true) {
            System.out.println("Введите минимальную оценку:");
            try {
                input = scanner.nextLine();
                labWork.setMinimalPoint(Integer.parseInt(input));
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        // Ввод описания
        while (true) {
            System.out.println("Введите описание:");
            try {
                input = scanner.nextLine();
                labWork.setDescription(input);
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        // Ввод среднего значения
        while (true) {
            System.out.println("Введите среднее значение:");
            try {
                input = scanner.nextLine();
                labWork.setAveragePoint(Long.valueOf(input));
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        // Ввод сложности
        while (true) {
            System.out.println("Введите сложность:");
            try {
                input = scanner.nextLine();
                labWork.setDifficulty(Difficulty.valueOf(input));
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }


        // Ввод имени автора
        while (true) {
            System.out.println("Введите имя автора:");
            try {
                name = scanner.nextLine();
                if (!(name.isEmpty())) {
                    break;
                }else {
                    System.out.println("xcvb");
                }
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        // Ввод даты рождения автора
        while (true) {
            System.out.println("Введите дату рождения автора (yyyy-MM-dd):");
            try {
                input = scanner.nextLine();
                birthday = String.valueOf(LocalDate.parse(input)); // Используем LocalDate для даты
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        // Ввод роста автора
        while (true) {
            System.out.println("Введите рост автора:");
            try {
                input = scanner.nextLine();
                height = Double.parseDouble(input);
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }

        // Ввод паспорта автора
        while (true) {
            System.out.println("Введите паспортный ID автора:");
            try {
                passportID = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("Неверный ввод: " + input);
            }
        }
        System.out.println(name);
        person = new Person(name, birthday, height, passportID);

        labWork.setAuthor(person);
        return labWork;
    }
}
