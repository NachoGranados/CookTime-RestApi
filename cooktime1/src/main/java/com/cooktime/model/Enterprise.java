package com.cooktime.model;

public class Enterprise {
    
    private String name;
    private String logo;
    private String conctact;
    private String schedule;
    
    // RestApi de Google Maps
    private String direction;

    public Enterprise(String name, String logo, String conctact, String schedule, String direction) {
        
        this.name = name;
        this.logo = logo;
        this.conctact = conctact;
        this.schedule = schedule;
        this.direction = direction;
        
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

    public String getConctact() {
        
        return conctact;
        
    }

    public void setConctact(String conctact) {
        
        this.conctact = conctact;
        
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
    
}
