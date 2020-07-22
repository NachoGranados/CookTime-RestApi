package com.cooktime.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jettison.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserJson {
    
    private static BinaryTree binaryTree = new BinaryTree();
    private static AVLTree avlTree = RecipeJson.getAVLTree();
    
    public static void insert(String email, String name, String lastName, int age, String password, String photo,
                               boolean chef) throws JSONException, IOException {
        
        binaryTree.insert1(email, name, lastName, age, password, photo, chef);
        
        ArrayList<Recipe> myMenuList = new ArrayList<Recipe>();
        ArrayList<String> followers = new ArrayList<String>();
        ArrayList<String> followed = new ArrayList<String>();
        
        JSONObject newUser = new JSONObject();
    
        newUser.put("email", email);
        newUser.put("name", name);
        newUser.put("lastName", lastName);
        newUser.put("age", age);
        newUser.put("password", password);        
        newUser.put("photo", photo);        
        newUser.put("myMenuList", myMenuList);
        newUser.put("followers", followers);
        newUser.put("followed", followed);
        newUser.put("chef", chef);
                
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
    
    public static void insertChef(String email) {
        
        User oldUser = binaryTree.getUser(email);
        
        String name = oldUser.getName();
        String lastName = oldUser.getLastName();
        int age = oldUser.getAge();
        String password = oldUser.getPassword();
        String photo = oldUser.getPhoto();
        ArrayList<Recipe> myMenuList = oldUser.getMyMenuList();
        ArrayList<String> followers = oldUser.getFollowers();
        ArrayList<String> followed = oldUser.getFollowed();
        boolean chef = oldUser.getChef();
        
        JSONObject oldUserJson = new JSONObject();

        oldUserJson.put("email", email);
        oldUserJson.put("name", name);
        oldUserJson.put("lastName", lastName);
        oldUserJson.put("age", age);
        oldUserJson.put("password", password);
        oldUserJson.put("photo", photo);
        oldUserJson.put("myMenuList", myMenuList);
        oldUserJson.put("followers", followers);
        oldUserJson.put("followed", followed);
        oldUserJson.put("chef", chef);
                        
        JSONObject newUserJson = new JSONObject();

        newUserJson.put("email", email);
        newUserJson.put("name", name);
        newUserJson.put("lastName", lastName);
        newUserJson.put("age", age);
        newUserJson.put("password", password);
        newUserJson.put("photo", photo);
        newUserJson.put("myMenuList", myMenuList);
        newUserJson.put("followers", followers);
        newUserJson.put("followed", followed);
        newUserJson.put("chef", true);
        
        binaryTree.remove(email);
        
        binaryTree.insert2(email, name, lastName, age, password, photo, myMenuList, followers, followed, true);

        JSONParser parser = new JSONParser();

        try {

            Object jsonFile = parser.parse(new FileReader("users.json"));

            JSONArray userList = (JSONArray) jsonFile;
            
            userList.remove(oldUserJson);

            userList.add(newUserJson);

            FileWriter file = new FileWriter("users.json");

            file.write(userList.toString());
            file.flush();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        } 
        
    }
    
    public static void insertMyMenuList(String email, String newRecipe) {

        User oldUser = binaryTree.getUser(email);

        String name = oldUser.getName();
        String lastName = oldUser.getLastName();
        int age = oldUser.getAge();
        String password = oldUser.getPassword();
        String photo = oldUser.getPhoto();
        ArrayList<Recipe> myMenuList = oldUser.getMyMenuList();
        ArrayList<String> followers = oldUser.getFollowers();
        ArrayList<String> followed = oldUser.getFollowed();
        boolean chef = oldUser.getChef();

        JSONObject oldUserJson = new JSONObject();

        oldUserJson.put("email", email);
        oldUserJson.put("name", name);
        oldUserJson.put("lastName", lastName);
        oldUserJson.put("age", age);
        oldUserJson.put("password", password);
        oldUserJson.put("photo", photo);
        oldUserJson.put("myMenuList", myMenuList);
        oldUserJson.put("followers", followers);
        oldUserJson.put("followed", followed);
        oldUserJson.put("chef", chef);

        JSONObject newUserJson = new JSONObject();
        
        myMenuList.add(avlTree.getRecipe(newRecipe));

        newUserJson.put("email", email);
        newUserJson.put("name", name);
        newUserJson.put("lastName", lastName);
        newUserJson.put("age", age);
        newUserJson.put("password", password);
        newUserJson.put("photo", photo);
        newUserJson.put("myMenuList", myMenuList);
        newUserJson.put("followers", followers);
        newUserJson.put("followed", followed);
        newUserJson.put("chef", chef);

        binaryTree.remove(email);

        binaryTree.insert2(email, name, lastName, age, password, photo, myMenuList, followers, followed, chef);

        JSONParser parser = new JSONParser();

        try {

            Object jsonFile = parser.parse(new FileReader("users.json"));

            JSONArray userList = (JSONArray) jsonFile;

            userList.remove(oldUserJson);

            userList.add(newUserJson);

            FileWriter file = new FileWriter("users.json");

            file.write(userList.toString());
            file.flush();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
        
    public static void insertBubbleSort(String email) {

        User oldUser = binaryTree.getUser(email);

        String name = oldUser.getName();
        String lastName = oldUser.getLastName();
        int age = oldUser.getAge();
        String password = oldUser.getPassword();
        String photo = oldUser.getPhoto();
        ArrayList<Recipe> myMenuList = oldUser.getMyMenuList();
        ArrayList<String> followers = oldUser.getFollowers();
        ArrayList<String> followed = oldUser.getFollowed();
        boolean chef = oldUser.getChef();

        JSONObject oldUserJson = new JSONObject();

        oldUserJson.put("email", email);
        oldUserJson.put("name", name);
        oldUserJson.put("lastName", lastName);
        oldUserJson.put("age", age);
        oldUserJson.put("password", password);
        oldUserJson.put("photo", photo);
        oldUserJson.put("myMenuList", myMenuList);
        oldUserJson.put("followers", followers);
        oldUserJson.put("followed", followed);
        oldUserJson.put("chef", chef);

        JSONObject newUserJson = new JSONObject();

        BubbleSort bubbleSort = new BubbleSort();
        
        bubbleSort.sort(myMenuList);

        newUserJson.put("email", email);
        newUserJson.put("name", name);
        newUserJson.put("lastName", lastName);
        newUserJson.put("age", age);
        newUserJson.put("password", password);
        newUserJson.put("photo", photo);
        newUserJson.put("myMenuList", myMenuList);
        newUserJson.put("followers", followers);
        newUserJson.put("followed", followed);
        newUserJson.put("chef", chef);

        binaryTree.remove(email);

        binaryTree.insert2(email, name, lastName, age, password, photo, myMenuList, followers, followed, chef);

        JSONParser parser = new JSONParser();

        try {

            Object jsonFile = parser.parse(new FileReader("users.json"));

            JSONArray userList = (JSONArray) jsonFile;

            userList.remove(oldUserJson);

            userList.add(newUserJson);

            FileWriter file = new FileWriter("users.json");

            file.write(userList.toString());
            file.flush();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
        
    public static void insertQuickSort(String email) {

        User oldUser = binaryTree.getUser(email);

        String name = oldUser.getName();
        String lastName = oldUser.getLastName();
        int age = oldUser.getAge();
        String password = oldUser.getPassword();
        String photo = oldUser.getPhoto();
        ArrayList<Recipe> myMenuList = oldUser.getMyMenuList();
        ArrayList<String> followers = oldUser.getFollowers();
        ArrayList<String> followed = oldUser.getFollowed();
        boolean chef = oldUser.getChef();

        JSONObject oldUserJson = new JSONObject();

        oldUserJson.put("email", email);
        oldUserJson.put("name", name);
        oldUserJson.put("lastName", lastName);
        oldUserJson.put("age", age);
        oldUserJson.put("password", password);
        oldUserJson.put("photo", photo);
        oldUserJson.put("myMenuList", myMenuList);
        oldUserJson.put("followers", followers);
        oldUserJson.put("followed", followed);
        oldUserJson.put("chef", chef);

        JSONObject newUserJson = new JSONObject();

        int minIndex = 0;
        int maxIndex = myMenuList.size() - 1;
        
        QuickSort quickSort = new QuickSort();
        
        quickSort.sort(myMenuList, minIndex, maxIndex);

        newUserJson.put("email", email);
        newUserJson.put("name", name);
        newUserJson.put("lastName", lastName);
        newUserJson.put("age", age);
        newUserJson.put("password", password);
        newUserJson.put("photo", photo);
        newUserJson.put("myMenuList", myMenuList);
        newUserJson.put("followers", followers);
        newUserJson.put("followed", followed);
        newUserJson.put("chef", chef);

        binaryTree.remove(email);

        binaryTree.insert2(email, name, lastName, age, password, photo, myMenuList, followers, followed, chef);

        JSONParser parser = new JSONParser();

        try {

            Object jsonFile = parser.parse(new FileReader("users.json"));

            JSONArray userList = (JSONArray) jsonFile;

            userList.remove(oldUserJson);

            userList.add(newUserJson);

            FileWriter file = new FileWriter("users.json");

            file.write(userList.toString());
            file.flush();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
        
    public static void insertRadixSort(String email) {

        User oldUser = binaryTree.getUser(email);

        String name = oldUser.getName();
        String lastName = oldUser.getLastName();
        int age = oldUser.getAge();
        String password = oldUser.getPassword();
        String photo = oldUser.getPhoto();
        ArrayList<Recipe> myMenuList = oldUser.getMyMenuList();
        ArrayList<String> followers = oldUser.getFollowers();
        ArrayList<String> followed = oldUser.getFollowed();
        boolean chef = oldUser.getChef();

        JSONObject oldUserJson = new JSONObject();

        oldUserJson.put("email", email);
        oldUserJson.put("name", name);
        oldUserJson.put("lastName", lastName);
        oldUserJson.put("age", age);
        oldUserJson.put("password", password);
        oldUserJson.put("photo", photo);
        oldUserJson.put("myMenuList", myMenuList);
        oldUserJson.put("followers", followers);
        oldUserJson.put("followed", followed);
        oldUserJson.put("chef", chef);

        JSONObject newUserJson = new JSONObject();

        RadixSort radix = new RadixSort();                      
        
        int size = myMenuList.size();                   
        
        ArrayList<Recipe> newMyMenuList = radix.sort(myMenuList, size);   
        
        newUserJson.put("email", email);
        newUserJson.put("name", name);
        newUserJson.put("lastName", lastName);
        newUserJson.put("age", age);
        newUserJson.put("password", password);
        newUserJson.put("photo", photo);
        newUserJson.put("myMenuList", newMyMenuList);
        newUserJson.put("followers", followers);
        newUserJson.put("followed", followed);
        newUserJson.put("chef", chef);

        binaryTree.remove(email);

        binaryTree.insert2(email, name, lastName, age, password, photo, myMenuList, followers, followed, chef);

        JSONParser parser = new JSONParser();

        try {

            Object jsonFile = parser.parse(new FileReader("users.json"));

            JSONArray userList = (JSONArray) jsonFile;

            userList.remove(oldUserJson);

            userList.add(newUserJson);

            FileWriter file = new FileWriter("users.json");

            file.write(userList.toString());
            file.flush();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
        
    public static void insertFollowers(String email, String newFollower) {
        
        System.out.println("newFollower " + newFollower);

        User oldUser = binaryTree.getUser(email);

        String name = oldUser.getName();
        String lastName = oldUser.getLastName();
        int age = oldUser.getAge();
        String password = oldUser.getPassword();
        String photo = oldUser.getPhoto();
        ArrayList<Recipe> myMenuList = oldUser.getMyMenuList();
        ArrayList<String> followers = oldUser.getFollowers();
        ArrayList<String> followed = oldUser.getFollowed();
        boolean chef = oldUser.getChef();

        JSONObject oldUserJson = new JSONObject();

        oldUserJson.put("email", email);
        oldUserJson.put("name", name);
        oldUserJson.put("lastName", lastName);
        oldUserJson.put("age", age);
        oldUserJson.put("password", password);
        oldUserJson.put("photo", photo);
        oldUserJson.put("myMenuList", myMenuList);
        oldUserJson.put("followers", followers);
        oldUserJson.put("followed", followed);
        oldUserJson.put("chef", chef);

        JSONObject newUserJson = new JSONObject();

        followers.add(newFollower);
        
        newUserJson.put("email", email);
        newUserJson.put("name", name);
        newUserJson.put("lastName", lastName);
        newUserJson.put("age", age);
        newUserJson.put("password", password);
        newUserJson.put("photo", photo);
        newUserJson.put("myMenuList", myMenuList);
        newUserJson.put("followers", followers);
        newUserJson.put("followed", followed);
        newUserJson.put("chef", chef);

        binaryTree.remove(email);

        binaryTree.insert2(email, name, lastName, age, password, photo, myMenuList, followers, followed, chef);

        JSONParser parser = new JSONParser();

        try {

            Object jsonFile = parser.parse(new FileReader("users.json"));

            JSONArray userList = (JSONArray) jsonFile;

            userList.remove(oldUserJson);

            userList.add(newUserJson);

            FileWriter file = new FileWriter("users.json");

            file.write(userList.toString());
            file.flush();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    
    public static void insertFollowed(String email, String newFollowed) {

        User oldUser = binaryTree.getUser(email);

        String name = oldUser.getName();
        String lastName = oldUser.getLastName();
        int age = oldUser.getAge();
        String password = oldUser.getPassword();
        String photo = oldUser.getPhoto();
        ArrayList<Recipe> myMenuList = oldUser.getMyMenuList();
        ArrayList<String> followers = oldUser.getFollowers();
        ArrayList<String> followed = oldUser.getFollowed();
        boolean chef = oldUser.getChef();

        JSONObject oldUserJson = new JSONObject();

        oldUserJson.put("email", email);
        oldUserJson.put("name", name);
        oldUserJson.put("lastName", lastName);
        oldUserJson.put("age", age);
        oldUserJson.put("password", password);
        oldUserJson.put("photo", photo);
        oldUserJson.put("myMenuList", myMenuList);
        oldUserJson.put("followers", followers);
        oldUserJson.put("followed", followed);
        oldUserJson.put("chef", chef);

        JSONObject newUserJson = new JSONObject();

        followed.add(newFollowed);

        newUserJson.put("email", email);
        newUserJson.put("name", name);
        newUserJson.put("lastName", lastName);
        newUserJson.put("age", age);
        newUserJson.put("password", password);
        newUserJson.put("photo", photo);
        newUserJson.put("myMenuList", myMenuList);
        newUserJson.put("followers", followers);
        newUserJson.put("followed", followed);
        newUserJson.put("chef", chef);

        binaryTree.remove(email);

        binaryTree.insert2(email, name, lastName, age, password, photo, myMenuList, followers, followed, chef);

        JSONParser parser = new JSONParser();

        try {

            Object jsonFile = parser.parse(new FileReader("users.json"));

            JSONArray userList = (JSONArray) jsonFile;

            userList.remove(oldUserJson);

            userList.add(newUserJson);

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






