package com.cooktime.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RecipeJson {

    private static AVLTree aVLTree = new AVLTree();
    private static final String directionJson = "C:\\Users\\ExtremeTech\\Documents\\NetBeansProjects\\API2\\cooktime1\\recipes.json";

    public static void insert(String name, String author, String type, int portions, int duration,
                              String time, int difficulty, String dietTag, String photo, String ingredients,
                              String steps, int price, int calification, int day, int month, int year) {

        aVLTree.insert1(name, author, type, portions, duration, time, difficulty, dietTag, photo, ingredients,
                        steps, price, calification, day, month, year);

        JSONObject newRecipe = new JSONObject();

        newRecipe.put("name", name);
        newRecipe.put("author", author);
        newRecipe.put("type", type);
        newRecipe.put("portions", portions);
        newRecipe.put("duration", duration);
        newRecipe.put("time", time);
        newRecipe.put("difficulty", difficulty);
        newRecipe.put("dietTag", dietTag);
        newRecipe.put("ingredients", ingredients);
        newRecipe.put("steps", steps);
        newRecipe.put("price", price);
        newRecipe.put("calification", calification);
        newRecipe.put("day", day);
        newRecipe.put("month", month);
        newRecipe.put("year", year);

        JSONParser parser = new JSONParser();

        try {

            Object jsonFile = parser.parse(new FileReader(directionJson)); 

            JSONArray recipeList = (JSONArray) jsonFile;

            recipeList.add(newRecipe);

            FileWriter file = new FileWriter(directionJson);    

            file.write(recipeList.toString());
            file.flush();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    
    public static void insertCalification(String name, int newCalification) {         
            
        Recipe oldRecipe = aVLTree.getRecipe(name);
        
        String author = oldRecipe.getAuthor();
        String type = oldRecipe.getType();
        int portions = oldRecipe.getPortions();
        int duration = oldRecipe.getDuration();
        String time = oldRecipe.getTime();
        int difficulty = oldRecipe.getDifficulty();
        String dietTag = oldRecipe.getDietTag();
        String photo = oldRecipe.getPhoto();
        String ingredients = oldRecipe.getIngredients();
        String steps = oldRecipe.getSteps();
        int price = oldRecipe.getPrice();
        int calification = oldRecipe.getCalification();
        int day = oldRecipe.getDay();
        int month = oldRecipe.getMonth();
        int year = oldRecipe.getYear();
        ArrayList<String> commentary = oldRecipe.getCommentary();
        
        JSONObject oldRecipeJson = new JSONObject();
        
        oldRecipeJson.put("name", name);
        oldRecipeJson.put("author", author);
        oldRecipeJson.put("type", type);
        oldRecipeJson.put("portions", portions);
        oldRecipeJson.put("duration", duration);
        oldRecipeJson.put("time", time);
        oldRecipeJson.put("difficulty", difficulty);
        oldRecipeJson.put("dietTag", dietTag);
        oldRecipeJson.put("ingredients", ingredients);
        oldRecipeJson.put("steps", steps);
        oldRecipeJson.put("price", price);
        oldRecipeJson.put("calification", calification);
        oldRecipeJson.put("day", day);
        oldRecipeJson.put("month", month);
        oldRecipeJson.put("year", year);
        oldRecipeJson.put("commentary", commentary);
        
        JSONObject newRecipeJson = new JSONObject();

        newRecipeJson.put("name", name);
        newRecipeJson.put("author", author);
        newRecipeJson.put("type", type);
        newRecipeJson.put("portions", portions);
        newRecipeJson.put("duration", duration);
        newRecipeJson.put("time", time);
        newRecipeJson.put("difficulty", difficulty);
        newRecipeJson.put("dietTag", dietTag);
        newRecipeJson.put("ingredients", ingredients);
        newRecipeJson.put("steps", steps);
        newRecipeJson.put("price", price);
        newRecipeJson.put("calification", calification + newCalification);
        newRecipeJson.put("day", day);
        newRecipeJson.put("month", month);
        newRecipeJson.put("year", year);
        newRecipeJson.put("commentary", commentary);
        
        aVLTree.remove(name);
        
        aVLTree.insert2(name, author, type, portions, duration, time, difficulty, dietTag, photo, ingredients,
                        steps, price, calification + newCalification, day, month, year, commentary);
        
        JSONParser parser = new JSONParser();

        try {

            Object jsonFile = parser.parse(new FileReader(directionJson)); 

            JSONArray recipeList = (JSONArray) jsonFile;

            recipeList.remove(oldRecipeJson);

            recipeList.add(newRecipeJson);
            
            FileWriter file = new FileWriter(directionJson);    

            file.write(recipeList.toString());
            file.flush();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    
    public static void insertCommentary(String name, String newCommentary) {         
            
        Recipe oldRecipe = aVLTree.getRecipe(name);
        
        String author = oldRecipe.getAuthor();
        String type = oldRecipe.getType();
        int portions = oldRecipe.getPortions();
        int duration = oldRecipe.getDuration();
        String time = oldRecipe.getTime();
        int difficulty = oldRecipe.getDifficulty();
        String dietTag = oldRecipe.getDietTag();
        String photo = oldRecipe.getPhoto();
        String ingredients = oldRecipe.getIngredients();
        String steps = oldRecipe.getSteps();
        int price = oldRecipe.getPrice();
        int calification = oldRecipe.getCalification();
        int day = oldRecipe.getDay();
        int month = oldRecipe.getMonth();
        int year = oldRecipe.getYear();
        ArrayList<String> commentary = oldRecipe.getCommentary();
                
        JSONObject oldRecipeJson = new JSONObject();
        
        oldRecipeJson.put("name", name);
        oldRecipeJson.put("author", author);
        oldRecipeJson.put("type", type);
        oldRecipeJson.put("portions", portions);
        oldRecipeJson.put("duration", duration);
        oldRecipeJson.put("time", time);
        oldRecipeJson.put("difficulty", difficulty);
        oldRecipeJson.put("dietTag", dietTag);
        oldRecipeJson.put("ingredients", ingredients);
        oldRecipeJson.put("steps", steps);
        oldRecipeJson.put("price", price);
        oldRecipeJson.put("calification", calification);
        oldRecipeJson.put("day", day);
        oldRecipeJson.put("month", month);
        oldRecipeJson.put("year", year);
        oldRecipeJson.put("commentary", commentary);
        
        JSONObject newRecipeJson = new JSONObject();
        
        commentary.add(newCommentary);

        newRecipeJson.put("name", name);
        newRecipeJson.put("author", author);
        newRecipeJson.put("type", type);
        newRecipeJson.put("portions", portions);
        newRecipeJson.put("duration", duration);
        newRecipeJson.put("time", time);
        newRecipeJson.put("difficulty", difficulty);
        newRecipeJson.put("dietTag", dietTag);
        newRecipeJson.put("ingredients", ingredients);
        newRecipeJson.put("steps", steps);
        newRecipeJson.put("price", price);
        newRecipeJson.put("calification", calification);
        newRecipeJson.put("day", day);
        newRecipeJson.put("month", month);
        newRecipeJson.put("year", year);
        newRecipeJson.put("commentary", commentary);
        
        aVLTree.remove(name);
        
        aVLTree.insert2(name, author, type, portions, duration, time, difficulty, dietTag, photo, ingredients,
                        steps, price, calification, day, month, year, commentary);
        
        JSONParser parser = new JSONParser();

        try {

            Object jsonFile = parser.parse(new FileReader(directionJson)); 

            JSONArray recipeList = (JSONArray) jsonFile;

            recipeList.remove(oldRecipeJson);

            recipeList.add(newRecipeJson);
            
            FileWriter file = new FileWriter(directionJson);    

            file.write(recipeList.toString());
            file.flush();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    
    public static AVLTree getAVLTree() {

        return aVLTree;

    }

}
