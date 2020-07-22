package com.cooktime.model;

import java.util.ArrayList;

public class MainUserMatches {
    
    public static void main() {
        
        BinaryTree binaryTree = new BinaryTree();
        
        binaryTree.insert1("@IgnacioA", "IgnacioA", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioB", "IgnacioB", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioC", "IgnacioC", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioD", "IgnacioD", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioE", "IgnacioE", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioF", "IgnacioF", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioG", "IgnacioG", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioH", "IgnacioH", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioI", "IgnacioI", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioJ", "IgnacioJ", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioK", "IgnacioK", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioL", "IgnacioL", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioM", "IgnacioM", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioN", "IgnacioN", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@Ignacio—", "Ignacio—", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioO", "IgnacioO", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert1("@IgnacioP", "IgnacioP", "Granados", 20, "abc", "photo.png", true);
                        
        ArrayList<User> newList = new ArrayList<User>();
        
        newList = binaryTree.matches("Ignacio", 7);
        
        print(newList);
        
    }
    
    private static void print(ArrayList<User> list) {
        
        for (int i = 0; i < list.size(); i ++) {
            
            System.out.println(list.get(i).getName());
            
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
