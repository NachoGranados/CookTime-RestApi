package com.cooktime.model;

import java.util.ArrayList;

public class MainRadixSort {

    public static void main(String args[]) {
        
        Recipe r1 = new Recipe("Arroz", "Juan", "Desayuno", 1, 0, "Aperitivo", 10, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 3, 12, 2, 2020);
        Recipe r2 = new Recipe("Avena", "Juan", "Desayuno", 1, 0, "Aperitivo", 20, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 9, 12, 2, 2020);
        Recipe r3 = new Recipe("Tortillas", "Juan", "Desayuno", 1, 0, "Aperitivo", 8, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 7, 12, 2, 2020);
        Recipe r4 = new Recipe("Pasta", "Juan", "Desayuno", 1, 0, "Aperitivo", 2, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 4, 12, 2, 2020);
        Recipe r5 = new Recipe("Huevo", "Juan", "Desayuno", 1, 0, "Aperitivo", 14, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 1, 12, 2, 2020);
                
        ArrayList<Recipe> list = new ArrayList<Recipe>();
        
        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        list.add(r5);
        
        /*
        list.add(r6);
        list.add(r7);
        list.add(r8);
        list.add(r9);
        list.add(r10);
        */
                
        RadixSort radix = new RadixSort();                      
        
        int size = list.size();                   
        
        ArrayList<Recipe> finalList = radix.sort(list, size);               
        
        for (int i = 0; i < finalList.size(); i++) {
            
            System.out.println(finalList.get(i).getName());
            
        }        
        
    }   
       
}
