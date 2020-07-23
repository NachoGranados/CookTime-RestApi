package com.cooktime.model;

import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jettison.json.JSONException;

public class MainPrueBA {
    
    public static void main(String args[]) throws JSONException, IOException {
        
        ArrayList<String> list = new ArrayList<String>();
        list.add("Nacho1");
        list.add("Nacho2");
        
        
        EnterpriseJson.insert("Berenjena555", "logo.png", "Nacho", "24 horas", "Cartago", list);
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
