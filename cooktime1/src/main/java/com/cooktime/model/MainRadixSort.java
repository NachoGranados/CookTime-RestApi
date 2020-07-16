package com.cooktime.model;

import java.util.ArrayList;

public class MainRadixSort {

    public static void main(String args[]) {
        
        Recipe r1 = new Recipe("Arroz", "Juan", "Desayuno", 1, 0, "Aperitivo", 10, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 3, 4);    //3        //3
        Recipe r2 = new Recipe("Avena", "Juan", "Desayuno", 1, 0, "Aperitivo", 20, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 9, 6);    //5        //5
        Recipe r3 = new Recipe("Tortillas", "Juan", "Desayuno", 1, 0, "Aperitivo", 8, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 7, 5); //2        //1
        Recipe r4 = new Recipe("Pasta", "Juan", "Desayuno", 1, 0, "Aperitivo", 2, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 4, 10);    //1        //2
        Recipe r5 = new Recipe("Huevo", "Juan", "Desayuno", 1, 0, "Aperitivo", 14, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 1, 16);   //4        //4
        
        /*
        Recipe r6 = new Recipe("Huevo", "Juan", "Desayuno", 1, 0, "Aperitivo", 22, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 1, 16);
        Recipe r7 = new Recipe("Huevo", "Juan", "Desayuno", 1, 0, "Aperitivo", 40, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 1, 16);
        Recipe r8 = new Recipe("Huevo", "Juan", "Desayuno", 1, 0, "Aperitivo", 1, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 1, 16);
        Recipe r9 = new Recipe("Huevo", "Juan", "Desayuno", 1, 0, "Aperitivo", 9, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 1, 16);
        Recipe r10 = new Recipe("Huevo", "Juan", "Desayuno", 1, 0, "Aperitivo", 17, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 1, 16);
        */
        
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
