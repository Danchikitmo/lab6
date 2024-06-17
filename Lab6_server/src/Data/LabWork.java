package Data;

import com.google.gson.annotations.SerializedName;
import interfaces.Validatable;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class LabWork implements Validatable, Comparable<LabWork>, Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;

    public static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);  // ID генератор

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("coordinates")
    private Coordinates coordinates;

    @SerializedName("creationDate")
    private ZonedDateTime creationDate;

    @SerializedName("minimalPoint")
    private Integer minimalPoint;

    @SerializedName("description")
    private String description;

    @SerializedName("averagePoint")
    private long averagePoint;

    @SerializedName("difficulty")
    private Difficulty difficulty;

    @SerializedName("author")
    private Person author;

    public LabWork(String name, Coordinates coordinates,
                   ZonedDateTime creationDate, Integer minimalPoint,
                   String description, Long averagePoint,
                   Difficulty difficulty, Person author) {
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

    public LabWork() {
        this.id = generateID();
    }

    public Integer generateID() {
        return ID_GENERATOR.getAndIncrement();
    }

    @Override
    public boolean validated() {
        return this.id > 0
                && this.name != null && !this.name.isEmpty()
                && this.coordinates != null && this.coordinates.validated()
                && this.creationDate != null
                && this.minimalPoint != null && this.minimalPoint > 0
                && this.description != null && !this.description.isEmpty()
                && this.averagePoint > 0
                && this.difficulty != null
                && this.author != null && this.author.validated();
    }

    // Геттеры и сеттеры

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getMinimalPoint() {
        return minimalPoint;
    }

    public void setMinimalPoint(Integer minimalPoint) {
        this.minimalPoint = minimalPoint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint(long averagePoint) {
        this.averagePoint = averagePoint;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
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
    public int compareTo(LabWork other) {
        return Integer.compare(this.minimalPoint, other.minimalPoint);
    }
}
