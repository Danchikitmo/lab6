package Data;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private static final long serialVersionUID = 5760575944040770153L;
    private long x; // Поле не может быть null
    private long y; // Максимальное значение поля: 915

    public Coordinates(long x, long y) {
        if (y > 915) {
            throw new IllegalArgumentException("y cannot be greater than 915");
        }
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        if (x == 0) { // Проверка на null заменена на проверку на 0, так как x и y являются примитивами
            throw new IllegalArgumentException("x cannot be null");
        }
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        if (y > 915) {
            throw new IllegalArgumentException("y cannot be greater than 915");
        }
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
