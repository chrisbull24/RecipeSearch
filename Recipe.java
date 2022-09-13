/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cbull
 */
public class Recipe {
    private String name;
    private int cookTime;
    private String ingredients;
    
    public Recipe(String recipeName, int recipeCookingTime, String ingredients) {
        this.name = recipeName;
        this.cookTime = recipeCookingTime;
        this.ingredients = ingredients;
    }
    
    public String listIngredients() {
        return this.ingredients;
    }
    
    public int getCookingTime() {
        return this.cookTime;
    }
    
    public String getRecipeName() {
        return this.name;
    }
    
    public String toString() {
        return this.name + ", cooking time: " + this.cookTime;
    }
}
