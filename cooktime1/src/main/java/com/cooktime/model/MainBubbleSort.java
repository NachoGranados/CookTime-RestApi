package com.cooktime.model;

import java.util.ArrayList;

public class MainBubbleSort {

    public static void main() {
                
        Recipe r1 = new Recipe("Arroz", "Juan", "Desayuno", 1, 0, "Aperitivo", 10, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 3, 12, 2, 2020);
        Recipe r2 = new Recipe("Avena", "Juan", "Desayuno", 1, 0, "Aperitivo", 20, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 9, 17, 2, 2020);
        Recipe r3 = new Recipe("Tortillas", "Juan", "Desayuno", 1, 0, "Aperitivo", 8, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 7, 9, 2, 2020);
        Recipe r4 = new Recipe("Pasta", "Juan", "Desayuno", 1, 0, "Aperitivo", 2, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 4, 31, 2, 2020);
        Recipe r5 = new Recipe("Huevo", "Juan", "Desayuno", 1, 0, "Aperitivo", 14, "Vegetariana", "hola1.png", "Harina", "Comer", 100, 1, 15, 2, 2020);
        
        ArrayList<Recipe> list = new ArrayList<Recipe>();
        
        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        list.add(r5);
        
        BubbleSort bubbleSort = new BubbleSort();
        
        bubbleSort.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
            
            System.out.println(list.get(i).getName());
            
        }
        
    }
    
}
