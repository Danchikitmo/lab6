package Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;

    private String name; //Поле не может быть null, Строка не может быть пустой
    private String birthday; //Поле не может быть null
    private Double height; //Поле может быть null, Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Поле не может быть null

    public Person(String name, String birthday, Double height, String passportID) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (birthday == null) {
            throw new IllegalArgumentException("Birthday cannot be null");
        }
        if (height != null && height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }

        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
    }

    public Person(String authorName, LocalDateTime birthday, Double height, String passportID) {
        this.name = authorName;
        this.birthday = birthday.toString();
        this.height = height;
        this.passportID = generatePassportId();
    }

    private String generatePassportId() {
        return UUID.randomUUID().toString();
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        if (birthday == null) {
            throw new IllegalArgumentException("Birthday cannot be null");
        }
        this.birthday = birthday;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        if (height != null && height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        this.height = height;
    }

    @Override
    public String toString() {
        return "{" + name + ";" + birthday + ";" + height + ";" + passportID + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(passportID, person.passportID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportID);
    }
}
