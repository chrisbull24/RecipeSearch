/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cbull
 */
import java.util.Scanner;
import java.nio.file.Paths;

public class UserInterface {
    private Scanner scanner;
    
    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void start() {
        RecipeList recipes = new RecipeList();
        
        String nextLine = null;
        String recipeName  = null;
        String ingredients = "";
        int cookingTime = 0;
        String userCommand = "";
        
        System.out.println("File to read: ");
        String file = this.scanner.nextLine();
    
            try (Scanner fileScanner = new Scanner(Paths.get(file))) {  //reads the file and and creates a new RecipeList object with all recipes and components
                    
                while (fileScanner.hasNextLine()) {
                    nextLine = fileScanner.nextLine();  //sets recipe name as the value of the next line
                    recipeName = nextLine;
                        
                    nextLine = fileScanner.nextLine();  //sets cooking time as the value of the next line
                    cookingTime = Integer.valueOf(nextLine);
                        
                    nextLine = fileScanner.nextLine(); //moves to next line in file
                        
                    while (true) {
                        if (nextLine.equals("")) {  //if white space is detected, exit loop.
                            break;
                        }
                            
                        ingredients += nextLine + "\n"; //concatenate the next-read ingredient
                        nextLine = fileScanner.nextLine();
                    }
                        
                    recipes.addRecipe(new Recipe(recipeName, cookingTime, ingredients));    //adds recipe to list
                    ingredients = "";   //clears ingredients for next recipe
                }         
            } catch (Exception e) {}
            recipes.addRecipe(new Recipe(recipeName, cookingTime, ingredients));
        
        while (!userCommand.equals("stop")) {    //continuosly asks user for commands until they type stop
            
            System.out.println();
            System.out.println("Commands:");
            System.out.println("list - lists the recipes");
            System.out.println("stop - stops the program");
            System.out.println("find name - searches recipes by name");
            System.out.println("find cooking time - searches recipes by cooking time");
            System.out.println("find ingredient - searches recipes by ingredient");
            System.out.println();
            
            System.out.println("Enter a command:");
            userCommand = this.scanner.nextLine();
                
            if (userCommand.equals("list")) {   //list recipes
                    System.out.println("Recipes:");
                    recipes.listRecipes();
            }
            
            if (userCommand.equals("find name")) {
                System.out.println("Searched word: ");
                String searchedWord = scanner.nextLine();
                recipes.searchFor(searchedWord);
            }
            
            if (userCommand.equals("find cooking time")) {
                System.out.println("Max cooking time:");
                int maxCookingTime = Integer.valueOf(scanner.nextLine());
                recipes.maxCookingTime(maxCookingTime);
            }
            
            if (userCommand.equals("find ingredient")) {
                System.out.println("Ingredient:");
                String searchedIngredient = scanner.nextLine();
                recipes.findIngredient(searchedIngredient);
            }
        }
    }
}
