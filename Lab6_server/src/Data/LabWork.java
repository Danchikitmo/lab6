package Data;

import com.google.gson.annotations.SerializedName;
import interfaces.Validatable;

import java.io.Serial;
import java.time.ZonedDateTime;
import java.util.Objects;

public class LabWork implements Validatable, Comparable<LabWork> {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private ZonedDateTime creationDate;
    private Integer minimalPoint;
    private String description;
    private long averagePoint;
    private Difficulty difficulty;
    private Person author;

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

    public LabWork() { }

    public Integer generateID(){
        Integer id = (int) (Math.random() * 1000);
        this.id = id;
        return id;
    }

    @Override
    public boolean validated(){
        return this.id > 0
                && this.name != null && !this.name.isEmpty()
                && this.coordinates != null
                && this.creationDate != null
                && this.minimalPoint > 0
                && this.description != null && !this.description.isEmpty()
                && this.averagePoint > 0
                && this.difficulty != null
                && this.author != null && this.author.validated();
    }

    // Геттеры и сеттеры

    @SerializedName("id")
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @SerializedName("name")
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @SerializedName("coordinates")
    public Coordinates getCoordinates(){
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    @SerializedName("creationDate")
    public ZonedDateTime getCreationDate(){
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate){
        this.creationDate = creationDate;
    }

    @SerializedName("minimalPoint")
    public Integer getMinimalPoint(){
        return minimalPoint;
    }

    public void setMinimalPoint(Integer minimalPoint){
        this.minimalPoint = minimalPoint;
    }

    @SerializedName("description")
    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @SerializedName("averagePoint")
    public long getAveragePoint(){
        return averagePoint;
    }

    public void setAveragePoint(long averagePoint){
        this.averagePoint = averagePoint;
    }

    @SerializedName("difficulty")
    public Difficulty getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }

    @SerializedName("author")
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
