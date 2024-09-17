package builder;

import Data.Difficulty;
import Data.LabWork;

public class LabWorkBuilder extends Builder{
    public LabWork create(){
        System.out.println("Время создать лабораторную работу ");
        return new LabWork(
                new NameBuilder().create(),
                new CoordinateBuilder().create(),
                new ZonedDataTimeBuilder().creationDate(),
                intBuilder("minimalPoint"),
                new DescriptionBuilder().create(),
                longBuilder("averagePoint"),
                new BuilderOfEnum<>(Difficulty.class, "сложность", Builder.scanner).listen(),
                new PersonBuilder().create()
                );
    }
}
