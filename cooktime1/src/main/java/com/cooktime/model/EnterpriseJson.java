package com.cooktime.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jettison.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class EnterpriseJson {
    
    private static SplayTree splayTree = new SplayTree();
    
    public static void insert(String name, String logo, String contact, String schedule,
                              String direction, ArrayList<String> members) throws JSONException,
                              IOException {
        
        splayTree.insert(name, logo, contact, schedule, direction, members);
        
        JSONObject newEnterprise = new JSONObject();
    
        newEnterprise.put("name", name);
        newEnterprise.put("logo", logo);
        newEnterprise.put("contact", contact);
        newEnterprise.put("schedule", schedule);
        newEnterprise.put("direction", direction);
        newEnterprise.put("members", members);
        
        JSONParser parser = new JSONParser();
                        
        try {
            
            Object jsonFile = parser.parse(new FileReader("enterprises.json")); 
            
            JSONArray enterpriseList = (JSONArray) jsonFile;
            
            enterpriseList.add(newEnterprise);                        
            
            FileWriter file = new FileWriter("enterprises.json");
            
            file.write(enterpriseList.toString());
            file.flush();
            file.close();
                                                            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }  
        
    }   
        
    public static SplayTree getSplayTree() {
        
        return splayTree;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
