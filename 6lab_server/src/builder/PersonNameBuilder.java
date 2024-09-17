package builder;

public class PersonNameBuilder extends Builder{
    public String create() throws IllegalArgumentException{
        while(true){
            String name = stringBuilder("имя");
            if(!(name.isEmpty())){
                return name;
            } else {
                System.out.println("Дайте персонажу имя");
            }
        }
    }
}
