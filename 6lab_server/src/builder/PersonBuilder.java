package builder;

import Data.Person;


public class PersonBuilder extends Builder{

    public PersonBuilder(){

    }
    public Person create(){
        return new Person(
                new PersonNameBuilder().create(),
                stringBuilder("дату рождения"),
                doubleBuilder("вес")
        );
    }
}
