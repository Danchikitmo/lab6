package builder;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class ZonedDataTimeBuilder {
    public final ZonedDateTime dataTime;

    Scanner scanner = new Scanner(System.in);
    public ZonedDataTimeBuilder() {
        this.dataTime = ZonedDateTime.now();
    }

    public ZonedDateTime creationDate(){
        return dataTime;
    }
//    public ZonedDateTime createBirhtday() throws IllegalArgumentException{
//        while(true){
//            System.out.println("Введите дату и время в формате 'yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSSXXX':");
//            String dateTimeString = scanner.nextLine();
//            try {
//                return ZonedDateTime.parse(dateTimeString);
//            } catch (DateTimeParseException e){
//                System.err.println("Неверный формат даты и времени");
//            }
//        }
//    }
}
