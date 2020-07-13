package com.cooktime.model;

public class User {
    
    private String email;
    private String name;
    private String lastName;
    private int age;
    private String password;
    private String photo;
    //private String[] myMenuList;
    //private String[] followers;
    //private String[] followed;
    private boolean chef;
        
    public User(String email) {
        
        this.email = email;
        
    }

    public User(String email, String name, String lastName, int age, String password,
                String photo, boolean chef) {
        
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.photo = photo;
        //this.myMenuList = myMenuList;
        //this.followers = followers;
        //this.followed = followed;
        this.chef = chef;
        
    }

    public String getEmail() {
        
        return email;
        
    }

    public void setEmail(String email) {
        
        this.email = email;
        
    }

    public String getName() {
        
        return name;
        
    }

    public void setName(String name) {
        
        this.name = name;
        
    }

    public String getLastName() {
        
        return lastName;
        
    }

    public void setLastName(String lastName) {
        
        this.lastName = lastName;
        
    }

    public int getAge() {
        
        return age;
        
    }

    public void setAge(int age) {
        
        this.age = age;
        
    }

    public String getPassword() {
        
        return password;
        
    }

    public void setPassword(String password) {
        
        this.password = password;
        
    }

    public String getPhoto() {
        
        return photo;
        
    }

    public void setPhoto(String photo) {
        
        this.photo = photo;
        
    }

    /*
    
    public String[] getMyMenuList() {
        
        return myMenuList;
        
    }
    
    public void setMyMenuList(String[] myMenuList) {
        
        this.myMenuList = myMenuList;
        
    }

    public String[] getFollowers() {
        
        return followers;
        
    }

    public void setFollowers(String[] followers) {
        
        this.followers = followers;
        
    }

    public String[] getFollowed() {
        
        return followed;
        
    }

    public void setFollowed(String[] followed) {
        
        this.followed = followed;
        
    }

    */

    public boolean isChef() {
        
        return chef;
        
    }

    public void setChef(boolean chef) {
        
        this.chef = chef;
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        return true;
    }
    
}
