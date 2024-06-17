package builder;

public class DescriptionBuilder extends Builder{
    public String create() throws IllegalArgumentException{
        while(true){
            String discription = stringBuilder("описание");
            if(!(discription.isEmpty())){
                return discription;
            } else {
                System.out.println("Дайте описание");
            }
        }
    }
}
