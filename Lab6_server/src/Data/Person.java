package Data;

import com.google.gson.annotations.SerializedName;
import interfaces.Validatable;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Person implements Validatable, Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;

    @SerializedName("name")
    private String name; // Поле не может быть null, Строка не может быть пустой

    @SerializedName("birthday")
    private String birthday; // Поле не может быть null

    @SerializedName("height")
    private Double height; // Поле может быть null, Значение поля должно быть больше 0

    @SerializedName("passportID")
    private String passportID; // Значение этого поля должно быть уникальным, Поле не может быть null

    public Person(String name, String birthday, Double height) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.passportID = generatePassportId();
    }

    public Person() {

    }

    public String generatePassportId() {
        return String.valueOf(Objects.hash(passportID));
    }

    @Override
    public boolean validated() {
        return this.name != null && !this.name.isEmpty()
                && this.birthday != null
                && (this.height == null || this.height > 0)
                && this.passportID != null && !this.passportID.isEmpty();
    }

    // Геттеры и сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    @Override
    public String toString() {
        return "{" + name + ";" + birthday + ";" + height + ";" + passportID + "}";
    }
}
