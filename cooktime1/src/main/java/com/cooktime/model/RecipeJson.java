package com.cooktime.model;

import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RecipeJson {

    private static AVLTree aVLTree = new AVLTree();

    public static void insert(String name, String author, String type, int portions, int duration,
                              String time, int difficulty, String dietTag, String photo, String ingredients,
                              String steps, int price, int calification, int publication) {

        aVLTree.insert(name, author, type, portions, duration, time, difficulty, dietTag, photo, ingredients,
                       steps, price, calification, publication);

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

        JSONParser parser = new JSONParser();

        try {

            Object jsonFile = parser.parse(new FileReader("recipes.json"));

            JSONArray recipeList = (JSONArray) jsonFile;

            recipeList.add(newRecipe);

            FileWriter file = new FileWriter("recipes.json");

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
