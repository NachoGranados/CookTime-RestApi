package com.cooktime.model;

import java.util.ArrayList;

public class Enterprise {
    
    private String name;
    private String logo;
    private String contact;
    private String schedule;
    private String direction;
    private ArrayList<String> members = new ArrayList<String>();

    public Enterprise(String name, String logo, String contact, String schedule, String direction, ArrayList<String> members) {
        
        this.name = name;
        this.logo = logo;
        this.contact = contact;
        this.schedule = schedule;
        this.direction = direction;
        this.members = members;
        
    }             
    
    public String getName() {
        
        return name;
        
    }

    public void setName(String name) {
        
        this.name = name;
        
    }

    public String getLogo() {
        
        return logo;
        
    }

    public void setLogo(String logo) {
        
        this.logo = logo;
        
    }

    public String getContact() {
        
        return contact;
        
    }

    public void setContact(String contact) {
        
        this.contact = contact;
        
    }

    public String getSchedule() {
        
        return schedule;
        
    }

    public void setSchedule(String schedule) {
        
        this.schedule = schedule;
    }
    

    public String getDirection() {
        
        return direction;
        
    }

    public void setDirection(String direction) {
        
        this.direction = direction;
        
    }

    public ArrayList<String> getMembers() {
        
        return members;
        
    }

    public void setMembers(ArrayList<String> members) {
        
        this.members = members;
        
    }
        
}
