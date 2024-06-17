package Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

public class LabWork implements Comparable<LabWork>, Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;
    private Integer id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer minimalPoint; //Значение поля должно быть больше 0
    private String description; //Строка не может быть пустой, Поле не может быть null
    private long averagePoint; //Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле может быть null
    private Person author; //Поле может быть null

    public LabWork(String name, Coordinates coordinates,
                   ZonedDateTime creationDate, Integer minimalPoint,
                   String description, Long averagePoint,
                   Difficulty difficulty, Person author){
        this.id = generateID();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.minimalPoint = minimalPoint;
        this.description = description;
        this.averagePoint = averagePoint;
        this.difficulty = difficulty;
        this.author = author;
    }

    public LabWork() {}

    public Integer generateID(){
        return (int) (Math.random() * 1000);
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate(){
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate){
        this.creationDate = creationDate;
    }

    public Integer getMinimalPoint(){
        return minimalPoint;
    }

    public void setMinimalPoint(Integer minimalPoint){
        this.minimalPoint = minimalPoint;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public long getAveragePoint(){
        return averagePoint;
    }

    public void setAveragePoint(long averagePoint){
        this.averagePoint = averagePoint;
    }

    public Difficulty getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }

    public Person getAuthor(){
        return author;
    }

    public void setAuthor(Person author){
        this.author = author;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LabWork labWork = (LabWork) object;
        return Objects.equals(id, labWork.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, minimalPoint, description, averagePoint, difficulty, author);
    }

    @Override
    public String toString() {
        return "LabWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", minimalPoint=" + minimalPoint +
                ", description='" + description + '\'' +
                ", averagePoint=" + averagePoint +
                ", difficulty=" + difficulty +
                ", author=" + author +
                '}';
    }

    @Override
    public int compareTo(LabWork other){
        return Integer.compare(this.minimalPoint, other.minimalPoint);
    }
}
