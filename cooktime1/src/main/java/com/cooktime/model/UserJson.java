package com.cooktime.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.codehaus.jettison.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserJson {
    
    private static BinaryTree binaryTree = new BinaryTree();
    
    public static void insert(String email, String name, String lastName, int age, String password,
                              String photo, boolean chef) throws JSONException, IOException {
        
        binaryTree.insert(email, name, lastName, age, password, photo, chef);
        
        JSONObject newUser = new JSONObject();
    
        newUser.put("email", email);
        newUser.put("name", name);
        newUser.put("lastName", lastName);
        newUser.put("age", age);
        newUser.put("password", password);        
        newUser.put("photo", photo);
        
        /*
        newUser.put("myMenuList", myMenuList);
        newUser.put("followers", followers);
        newUser.put("followed", followed);
        newUser.put("chef", chef);
        */
        
        JSONParser parser = new JSONParser();
                        
        try {
            
            Object jsonFile = parser.parse(new FileReader("users.json")); 
            
            JSONArray userList = (JSONArray) jsonFile;
            
            userList.add(newUser);                        
            
            FileWriter file = new FileWriter("users.json");
            
            file.write(userList.toString());
            file.flush();
            file.close();
                                                            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }  
        
    }
    
    public static BinaryTree getBinaryTree() {
        
        return binaryTree;
        
    }
                    
}






