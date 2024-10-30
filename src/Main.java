import java.util.ArrayList;

interface Ingredient{
    public String getName();
    public double getQuantity();
}

class SolidIngredient implements Ingredient{
    private String name;
    private double quantity;

    public SolidIngredient(String name, double quantity){
        this.name = name;
        this.quantity = quantity;
    }
    public String getName(){
        return name;
    }
    public double getQuantity(){
        return quantity;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}

class LiquidIngredient implements Ingredient{
    private String name;
    private double quantity;

    public LiquidIngredient(String name, double quantity){
        this.name = name;
        this.quantity = quantity;
    }
    public String getName(){
        return name;
    }
    public double getQuantity(){
        return quantity;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}

class Recipe<T extends Ingredient>{
    private String name;
    private ArrayList<String> instructions;
    private ArrayList<T> ingredients;

    public Recipe(String name, ArrayList<String> instructions, ArrayList<T> ingredients){
        this.name = name;
        this.instructions = new ArrayList<>();
        this.ingredients = new ArrayList<>();
    }
    public void addIngredient(T ing){
        ingredients.add(ing);
    }
    public String print(){

    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}