package managers;

//import Data.Comparator.LabWorkComparator;

import Adapter.ZonedDataTimeAdapter;
import Data.LabWork;
import builder.LabWorkBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exceptions.EmptyCollectionException;
import exceptions.InvalidDataException;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;

public class CollectionManager {
    private final LocalDate localDate;

    public CollectionManager(){
        localDate = LocalDate.parse(LocalDate.now().toString());
    }

    private static Vector<LabWork> MyCollection = new Vector<>();

    public static boolean idIdentifier(LabWork labWork){
        for(LabWork value: MyCollection){
            if(labWork.getId() == value.getId()){
                return false;
            }
        }
        return true;
    }

    public void help(){
        System.out.println("""
                help : вывести справку по доступным командам
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add {element} : добавить новый элемент в коллекцию
                update id {element} : обновить значение элемента коллекции, id которого равен заданному
                remove_by_id id : удалить элемент из коллекции по его id
                clear : очистить коллекцию
                save : сохранить коллекцию в файл
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                exit : завершить программу (без сохранения в файл)
                insert_at index {element} : добавить новый элемент в заданную позицию
                remove_first : удалить первый элемент из коллекции
                reorder : отсортировать коллекцию в порядке, обратном нынешнему
                count_less_than_minimal_point minimalPoint : вывести количество элементов, значение поля minimalPoint которых меньше заданного
                filter_greater_than_difficulty difficulty : вывести элементы, значение поля difficulty которых больше заданного, VERY_EASY = 1, INSANE = 2, VERY_HARD = 3
                print_field_descending_author : вывести значения поля author всех элементов в порядке убывания""");
    }

    public LabWork getPersonById(Integer id){
        for(LabWork labWork: MyCollection){
            if(id == labWork.getId()){
                return labWork;
            }
        }
        return null;
    }

    public static void add(LabWork labWork){
        MyCollection.add(labWork);
    }

    public static Vector<LabWork> getLabWorks(){
        return MyCollection;
    }

    public void insertAt(Integer index, LabWork labWork) throws InvalidDataException{
        if (index < 0 || index > MyCollection.size()) {
            MyCollection.add(labWork);
        }
        MyCollection.add(index, labWork);
        if (MyCollection.get(index).equals(labWork)) {
            System.out.println("Элемент успешно добавлен на позицию: " + index);
            System.out.println(MyCollection.get(index));
        } else {
            System.err.println("Не удалось добавить элемент на позицию: " + index);
        }
    }

    public void showAt(Integer index) throws InvalidDataException{
        System.out.println(MyCollection.get(index));
    }

    public void updateID(Integer id) throws InvalidDataException, NoSuchElementException{
        LabWork oldPerson = getPersonById(id);
        if(oldPerson == null){
            throw new NoSuchElementException("Такого человека нет в коллекции");
        }
        MyCollection.remove(oldPerson);
        LabWorkBuilder LabWork = new LabWorkBuilder();
        LabWork newLabWork = LabWork.create();
        newLabWork.setId(id);
        MyCollection.add(newLabWork);
        System.out.println("Человек успешено обновлен");
    }

    public LabWork getWorksMinimalPoint(Integer minimalPoint){
        int counter = 0;
        for (LabWork labWork: MyCollection) {
            if(minimalPoint > labWork.getMinimalPoint()){
                counter++;
            }
        }
        if (counter != 0){
            System.out.println("Элементов, у которых minimalPoint < " + minimalPoint + " :");
            System.out.println(counter);
        } else {
            throw new NoSuchElementException();
        }

        return null;
    }

    public LabWork getWorksDifficulty(Integer difficulty){
        for (LabWork labWork: MyCollection) {
            String difficultyLabWork = labWork.getDifficulty().toString();
            Integer difficulty1 = 0;
            if(difficultyLabWork == "VERY_EASY"){
                difficulty1 = 1;
            } else if(difficultyLabWork == "INSANE"){
                difficulty1 = 2;
            } else if(difficultyLabWork == "VERY_HARD"){
                difficulty1 = 3;
            }
            if(difficulty < difficulty1){
                System.out.println(labWork);
            }
            }
        return null;
    }

    public void show() throws EmptyCollectionException{
        Collections.sort(MyCollection);
        if(!MyCollection.isEmpty()){
            System.out.println("Содержимое коллекции:");
            for(LabWork i: MyCollection){
                System.out.println(i);
            }
        } else {
            throw new EmptyCollectionException();
        }
    }

    public void removeElement(LabWork labWork) throws NoSuchElementException{
        if(MyCollection.contains(labWork)){
            MyCollection.remove(labWork);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void removeFirst() throws EmptyCollectionException{
        if(!MyCollection.isEmpty()){
            MyCollection.remove(0);
        } else {
            throw new EmptyCollectionException();
        }
    }

    public void getInfo(){
        System.out.println("Сохраняемый тип данных: " + LabWork.class + ", количество работ: " + MyCollection.size() + ", дата инициализации: " + localDate);
    }

    public void reoder() throws EmptyCollectionException{
        if(MyCollection.isEmpty()) throw new EmptyCollectionException();
        Collections.shuffle(MyCollection);
        System.out.println("Коллекция перемешалась");
    }

    public static void clear() {
        if(MyCollection.isEmpty()){
            System.out.println("Коллекция и так пуста");
        } else {
            MyCollection.clear();
            System.out.println("Коллекция очищена");
        }
    }

    public void save(){
        try {
            if(MyCollection.isEmpty()){
                System.out.println("Ваша коллекция пуста, если вы сохраните, то ваша прошлая коллекция исчезнет. Точно ли вы этого хотите?");
                System.out.println("y/n");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();
                if (answer.equals("y")){
                    FileManagers.clearFile();
                    System.out.println("Сохранение перезаписано");
                } else if (answer.equals("n")) {
                    String filePath = System.getenv("FILE_PATH");
                    MyCollection.addAll(FileManagers.readFile(filePath).getLabWorks());
                    System.out.println("Сохранение восстановлено");
                    return;
                } else {
                    System.out.println("Нет такого варианта ответа");
                }
            } else {
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(ZonedDateTime.class, new ZonedDataTimeAdapter())
                        .create();

                String json = gson.toJson(MyCollection);
                FileManagers.writeFile(json);
            }
        } catch (NullPointerException e){
            System.out.println("Что-то пошло не так, попробуйте снова");
        }
    }

    public boolean checkId(Vector<LabWork> labWorks){
        HashSet<Integer> idCollection = new HashSet<>();
        if(labWorks.size() != 1){
            for (LabWork labWork: labWorks){
                if(!idCollection.contains(labWork.getId())){
                    idCollection.add(labWork.getId());
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static LocalDate date;
    public static LocalDate getInitDate(){
        return date = LocalDate.parse(LocalDate.now().toString());
    }

    public static void setVector(Vector<LabWork> MyCollection){
        CollectionManager.MyCollection = MyCollection;
    }

    public void addToCollection(Vector<LabWork> labWorks){
        if(checkId(labWorks)){
            MyCollection.addAll(labWorks);
        } else {
            System.err.println("Что-то не так с файлом, данные не подгрузились");
        }
    }

    public static Scanner reader;
    public void executeScript(String filePath, CommandManagers commandManager, Set<String> executeScript) {
        try (Scanner scriptScanner = new Scanner(new File(filePath))) {
            reader = scriptScanner;
            while (scriptScanner.hasNextLine()) {
                String commandToSplit = (scriptScanner.nextLine().trim() + " ").toLowerCase();
                String[] commandParts = commandToSplit.split(" ", 2);
                String commandName = commandParts[0];
                String args = (commandParts.length > 1) ? commandParts[1] : "";
                commandManager.execute(commandName, args);
                if (commandName.equals("execute_script")) {
                    if (executeScript.contains(args)) {
                        System.err.println("Найдена рекурсия");
                        executeScript.clear();
                        break;
                    }
                    executeScript.add(args);
                    commandManager.execute(commandName, args);
                    executeScript.remove(args);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл скрипта не найден: " + filePath);
        } catch (NoSuchElementException e) {
            System.err.println("Ошибка чтения файла скрипта: " + filePath);
        } catch (IllegalStateException e){
            System.err.println("Чиним программу, можете продолжать дальше");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
