package Data;

import com.google.gson.annotations.SerializedName;
import interfaces.Validatable;

import java.io.Serial;
import java.io.Serializable;

public class Coordinates implements Validatable, Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;

    @SerializedName("x")
    private long x; // Поле не может быть null

    @SerializedName("y")
    private long y; // Максимальное значение поля: 915

    public Coordinates(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    @Override
    public boolean validated() {
        return y <= 915;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
