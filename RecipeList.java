/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cbull
 */
import java.util.ArrayList;

public class RecipeList {
    private ArrayList<Recipe> recipes;
    
    public RecipeList() {
        this.recipes = new ArrayList<>();
    }
    
    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }
    
    public void listRecipes() {
        for (Recipe recipe: this.recipes) {
            System.out.println(recipe);
        }
    }
    
    public void searchFor(String searchedWord) {
        System.out.println("Recipes:");
        for (Recipe recipe: this.recipes) {
            if (recipe.getRecipeName().contains(searchedWord)) {
                System.out.println(recipe);
            }
        }
    }
    
    public void maxCookingTime(int maxTime) {
        System.out.println("Recipes:");
        for (Recipe recipe: this.recipes) {
            if (recipe.getCookingTime() <= maxTime) {
                System.out.println(recipe);
            }
        }
    }
    
    public void findIngredient(String ingredient) {
        System.out.println("Recipes:");
        String[] ingredientsSplit;
        for (Recipe recipe: this.recipes) {
            ingredientsSplit = recipe.listIngredients().split("\n");
            for (int i = 0; i < ingredientsSplit.length; i++) {
                if (ingredientsSplit[i].equals(ingredient)) {
                    System.out.println(recipe);
                }
            }
        }
    }
}

