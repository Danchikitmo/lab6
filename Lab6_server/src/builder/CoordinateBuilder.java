package builder;

import Data.Coordinates;

public class CoordinateBuilder extends Builder{
    public Coordinates create(){
        return new Coordinates(longBuilder("Координата x: "), longBuilder("Координата y: "));
    }
}
