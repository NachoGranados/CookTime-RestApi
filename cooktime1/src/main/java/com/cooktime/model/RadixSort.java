package com.cooktime.model;

import java.util.ArrayList;

public class RadixSort {
    
    public static ArrayList<Recipe> sortedList = new ArrayList<Recipe>();
          
    public void sort(ArrayList<Recipe> array, int size) {
        
        for (int j = 0; j < size; j ++) {
            
            sortedList.add(array.get(j));
            
        }
        
        int max = getMax(array, size);
        
        for (int i = 1; max / i > 0; i *= 10) {
            
            count(array, size, i);
            
        }
        
    }
    
    public void count(ArrayList<Recipe> array, int size, int exp) {
        
        int output[] = new int[size];
        int count[] = new int[10];
        
        Recipe aux;
        
        for (int i = 0; i < size; i ++) {
            
            count[(array.get(i).getDifficulty() / exp) % 10] ++;
            
        }
        
        for (int i = 1; i < 10; i ++) {
            
            count[i] += count[i - 1];
            
        }
        
        for (int i = size - 1; i >= 0; i --) {         
                                    
            output[count[(array.get(i).getDifficulty() / exp) % 10] - 1] = array.get(i).getDifficulty();
            count[(array.get(i).getDifficulty() / exp) % 10] --;
            
            System.out.println(output[i]);
            
        }
        
        System.out.println("");
        
        for (int i = 0; i < size; i ++) {
            
            System.out.println("output " + output[i]);
                
            
            aux = getRecipe(array, output[i]);            
            sortedList.set(i, aux);
            
            /*
            
            
            aux = array.get(i);
            aux.setDifficulty(output[i]);
            
            System.out.println(output[i]);
            
            //array.set(i, aux)
            
            
            
            //System.out.println(output[i]);
            
            /*
            
            array.set(i, getRecipe(array, output[i]));
            
            System.out.println(output[i]);

            */
                        
        }
        
        System.out.println("");
                
    }
        
    public int getMax(ArrayList<Recipe> array, int size) {
        
        int max = array.get(0).getDifficulty();
        
        for (int i = 0; i < size; i ++) {
            
            if (array.get(i).getDifficulty() > max) {
                
                max = array.get(i).getDifficulty();
                
            }
            
        }
                
        return max;
                
    }
    
    private Recipe getRecipe(ArrayList<Recipe> array, int difficulty) {
                
        for (int i = 0; i < array.size(); i ++){
            
            if (array.get(i).getDifficulty() == difficulty) {
                
                return array.get(i);
                
            }
            
        }
        
        return array.get(0);
        
    }
          
}
