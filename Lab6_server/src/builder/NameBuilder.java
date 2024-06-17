package builder;

public class NameBuilder extends Builder{
    public String create() throws IllegalArgumentException{
        while(true){
            String name = stringBuilder("название");
            if(!(name.isEmpty())){
                return name;
            } else {
                System.out.println("Дайте название лабораторной работе");
            }
        }
    }
}
