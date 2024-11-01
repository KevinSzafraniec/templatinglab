import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

interface Ingredient{
    String getName();
    double getQuantity();
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
//    public void setName(String name){
//        this.name = name;
//    }
//    public void setQuantity(int quantity){
//        this.quantity = quantity;
//    }
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
//    public void setName(String name){
//        this.name = name;
//    }
//    public void setQuantity(int quantity){
//        this.quantity = quantity;
//    }
}

class Recipe<T extends Ingredient>{
    private String name;
    private String instructions;
    private ArrayList<T> ingredients;

    public Recipe(String name, String instructions){
        this.name = name;
        this.instructions = instructions;
        this.ingredients = new ArrayList<>();
    }
    public void addIngredient(T ing){
        ingredients.add(ing);
    }
    public String print(){
        String recpie = "";
        recpie+=name+"\n";
        recpie+=instructions+"\n";
        for (int i =0; i < ingredients.size(); i++){
            recpie+=ingredients.get(i)+"\n";
        }
        return recpie;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        int c2 = -1;
        String name = "";
        int qty = 0;
        String instructions = "";
        System.out.println("Recipe name: ");
        name = scan.nextLine();
        System.out.println("Recipe Instructions: ");
        instructions = scan.nextLine();
        Recipe<Ingredient> r = new Recipe<>(name, instructions);
        System.out.println("""
                1. Add Ingredient
                2. List Recipe
                3. Exit""");
        choice = scan.nextInt();
        while (choice!=3){
            if (choice == 1){
                System.out.println("""
                        1. Add Solid Ingredient
                        2. Add Liquid Ingredient""");
                c2 = scan.nextInt();
                if (c2 == 1){
                    System.out.println("Enter Ingredient Name: ");
                    name = scan.nextLine();
                    System.out.println("Enter Quantity Amt: ");
                    qty = Integer.parseInt(scan.nextLine());
                    r.addIngredient(new SolidIngredient(name, qty));
                }
                else if (c2 == 2){
                    System.out.println("Enter Ingredient Name: ");
                    name = scan.nextLine();
                    System.out.println("Enter Quantity Amt: ");
                    qty = Integer.parseInt(scan.nextLine());
                    r.addIngredient(new LiquidIngredient(name, qty));
                }
            }
            if (choice == 2){
                r.print();
            }
            System.out.println("""
                1. Add Ingredient
                2. List Recipe
                3. Exit""");
            choice = scan.nextInt();
        }
    }
}