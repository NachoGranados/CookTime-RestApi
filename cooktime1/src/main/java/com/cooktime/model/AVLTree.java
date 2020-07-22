package com.cooktime.model;

import com.cooktime.model.Recipe;
import java.util.ArrayList;
  
public class AVLTree { 
    
    private NodeAVLTree root;
    private ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    
    public boolean contains(String name) {
        
        return this.containsAux(name, this.root);
        
    }

    private boolean containsAux(String name, NodeAVLTree node) {
        
        if (node == null) {
            
            return false;
        
        } else {
            
            int compareResult = name.compareTo(node.getRecipe().getName());

            if (compareResult < 0) {

                return containsAux(name, node.getLeft());

            } else if (compareResult > 0) {

                return containsAux(name, node.getRight());

            } else {

                return true;

            }
        
        }
        
    }

    public Recipe getRecipe(String name) {

        return this.getRecipeAux(name, this.root);

    }

    private Recipe getRecipeAux(String name, NodeAVLTree node) {
        
        int compareResult = name.compareTo(node.getRecipe().getName());

        if (compareResult < 0) {

            return getRecipeAux(name, node.getLeft());

        } else if (compareResult > 0) {

            return getRecipeAux(name, node.getRight());

        } else {

            return node.getRecipe();

        }

    }
          
    private int height(NodeAVLTree node) {  
        
        if (node == null) {
            
            return 0;
            
        }
        
        return node.getHeight();  
        
    }  
  
    private int findMax(int height1, int height2) {  
        
        return (height1 > height2) ? height1 : height2;  
        
    }  
  
    private NodeAVLTree rightRotate(NodeAVLTree node1) {
        
        NodeAVLTree node2 = node1.getLeft();  
        NodeAVLTree node3 = node2.getRight();  
  
        node2.setRight(node1);
        node1.setLeft(node3);
        
        node1.setHeight(findMax(height(node1.getLeft()), height(node1.getRight())) + 1);
        node2.setHeight(findMax(height(node2.getLeft()), height(node2.getRight())) + 1);
        
        return node2; 
        
    }  
 
    private NodeAVLTree leftRotate(NodeAVLTree node1) {  
        
        NodeAVLTree node2 = node1.getRight();  
        NodeAVLTree node3 = node2.getLeft();  
    
        node2.setLeft(node1);
        node1.setRight(node3);
        
        node1.setHeight(findMax(height(node1.getLeft()), height(node1.getRight())) + 1);
        node2.setHeight(findMax(height(node2.getLeft()), height(node2.getRight())) + 1);
  
        return node2;  
        
    }  
   
    private int getBalance(NodeAVLTree node) {
        
        if (node == null) {
            
            return 0;
            
        }
        
        return height(node.getLeft()) - height(node.getRight()); 
        
    }         
    
    public void insert1(String name, String author, String type, int portions, int duration,
                       String time, int difficulty, String dietTag, String photo, String ingredients,
                       String steps, int price, int calification, int day, int month, int year) {

        Recipe recipe = new Recipe(name, author, type, portions, duration, time, difficulty, dietTag,
                                   photo, ingredients, steps, price, calification, day, month, year);

        this.root = this.insertAux(recipe, this.root);

    }
    
    public void insert2(String name, String author, String type, int portions, int duration,
                        String time, int difficulty, String dietTag, String photo, String ingredients,
                        String steps, int price, int calification, int day, int month, int year,
                        ArrayList<String> commentary) {

        Recipe recipe = new Recipe(name, author, type, portions, duration, time, difficulty, dietTag,
                                   photo, ingredients, steps, price, calification, day, month, year,
                                   commentary);

        this.root = this.insertAux(recipe, this.root);

    }
    
    private NodeAVLTree insertAux(Recipe recipe, NodeAVLTree node) {  
        
        if (node == null) {
            
            return new NodeAVLTree(recipe);  
            
        }
        
        int compareResult = recipe.getName().compareTo(node.getRecipe().getName());
        
        if (compareResult < 0) {

            node.setLeft(this.insertAux(recipe, node.getLeft()));

        } else if (compareResult > 0) {

            node.setRight(this.insertAux(recipe, node.getRight()));
            
        } else {
            
            return node;
            
        } 
        
        node.setHeight(findMax(height(node.getLeft()), height(node.getRight())) + 1);
           
        int balance = getBalance(node);  
        
        if (balance > 1) {
            
            int compare1 = recipe.getName().compareTo(node.getLeft().getRecipe().getName());
            
            if (compare1 < 0)  {
            
                return rightRotate(node); 
            
            } 

            if (compare1 > 0) {  

                node.setLeft(leftRotate(node.getLeft()));

                return rightRotate(node); 

            }
                        
        } else if (balance < -1) {
            
            int compare = recipe.getName().compareTo(node.getRight().getRecipe().getName());
        
         
            if (compare < 0) {  

                node.setRight(rightRotate(node.getRight()));

                return leftRotate(node);  

            } 

            if (compare > 0) {

                return leftRotate(node); 

            }
          
        }
        
        return node; 
                
    }  
    
    private NodeAVLTree findMin(NodeAVLTree node1) {  
        
        NodeAVLTree node2 = node1;  
  
        while (node2.getLeft() != null) {
            
            node2 = node2.getLeft(); 
            
        } 
  
        return node2;  
        
    }  
    
    public void remove(String name) {
        
        this.root = this.removeAux(name, this.root);
        
    }
    
    private NodeAVLTree removeAux(String name, NodeAVLTree node) {  
         
        if (node == null) {
            
            return node; 
            
        } 
        
        int compareResult = name.compareTo(node.getRecipe().getName());
        
        if (compareResult < 0) {
        
            node.setLeft(removeAux(name, node.getLeft()));
            
        } else if (compareResult > 0) {
        
            node.setRight(removeAux(name, node.getRight()));
            
        } else { 
  
            if ((node.getLeft() == null) || (node.getRight() == null)) {  
                
                NodeAVLTree current = null; 
                
                if (current == node.getLeft()) {
                    
                    current = node.getRight();
                    
                } 
                     
                else
                    current = node.getLeft();  
  
                if (current == null) {  
                    
                    current = node;  
                    node = null;  
                    
                } else {
                    
                    node = current;
                    
                }

            } else {  
    
                NodeAVLTree current = findMin(node.getRight());  
  
                node.setRecipe(current.getRecipe());                
                node.setRight(removeAux(current.getRecipe().getName(), node.getRight()));
                
            }  
            
        }  
        
        if (node == null) {
            
            return node; 
            
        }   
        
        node.setHeight(findMax(height(node.getLeft()), height(node.getRight())) + 1);
          
        int balance = getBalance(node);  
  
        if (balance > 1 && getBalance(node.getLeft()) >= 0) {
            
            return rightRotate(node);  
            
        }  
        
        if (balance > 1 && getBalance(node.getLeft()) < 0) {
            
            node.setLeft(leftRotate(node.getLeft()));
            
            return rightRotate(node);  
            
        }  
  
        if (balance < -1 && getBalance(node.getRight()) <= 0) {
            
            return leftRotate(node); 
            
        } 
  
        if (balance < -1 && getBalance(node.getRight()) > 0) {             
            
            node.setRight(rightRotate(node.getRight()));
                        
            return leftRotate(node);  
            
        }  
  
        return node;  
        
    } 
        
    public ArrayList<Recipe> inOrder() {

        this.recipeList.clear();

        return this.inOrderAux(recipeList, this.root);

    }

    private ArrayList<Recipe> inOrderAux(ArrayList<Recipe> recipeList, NodeAVLTree node) {

        if (node == null) {

            return null;

        }

        inOrderAux(recipeList, node.getLeft());
        recipeList.add(node.getRecipe());
        inOrderAux(recipeList, node.getRight());

        return recipeList;

    }
    
    public ArrayList<Recipe> matches(String name, int endIndex) {
                        
        ArrayList<Recipe> matchesList = new ArrayList<Recipe>();
        
        matchesList = matchesAux(matchesList, name, endIndex, this.root);
        
        ArrayList<Recipe> finalMatchesList = new ArrayList<Recipe>();
        
        int cont = 0;
        
        int size = matchesList.size();
        
        while (cont < 15) {
            
            if (cont < size) {
                
                finalMatchesList.add(matchesList.get(cont));
                
            } else {
                
                break;
                
            }            
            
            cont ++;
            
        }
                
        return finalMatchesList;
 
    }
    
    private ArrayList<Recipe> matchesAux(ArrayList<Recipe> matchesList, String name, int endIndex, NodeAVLTree node) {
        
      if (node == null) {
          
        return null;
        
      }
      
      int result = node.getRecipe().getName().substring(0, endIndex).compareTo(name);
              
      if (result == 0) {
          
          matchesList.add(node.getRecipe());
                    
      }
      
      matchesAux(matchesList, name, endIndex, node.getLeft());
      matchesAux(matchesList, name, endIndex, node.getRight());
      
      return matchesList;
      
    }

}  