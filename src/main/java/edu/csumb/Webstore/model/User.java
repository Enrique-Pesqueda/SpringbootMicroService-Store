//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

public class User
{
    private String name;
    private String id;
    private String description;
    private String imageURL;
    

    //Default Contructor
    public User(){ }
    //Contructor
    public User(String name, String id, String description, String imageURL){
        this.name = name;
        this.id = id;
        this.description = description;
        this.imageURL = imageURL;
    }

    //Accessors
    public String getId() { return id; }
    public String getImageurl(){ return imageURL; }
    public String getName(){ return name; }
    public String getDescription(){ return description; }
    
    //Mutators
    public void setId(String id) { this.id = id; }
    public void setImageurl(String imageURl){ this.imageURL = imageURL; }
    public void setName(String name){ this.name = name; } 
    public void setDescription(String description){ this.description = description; }
}