package request;

import Data.LabWork;
import Data.Person;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;
    private String message;
    private LabWork labWork;
    private Person person;

    // Конструктор с инициализацией message и labWork
    public Request(String message) {
        this.message = message;
        this.labWork = labWork;
    }

    // Геттеры и сеттеры
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LabWork getLabWork() {
        return labWork;
    }

    public void setLabWork(LabWork labWork) {
        this.labWork = labWork;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
