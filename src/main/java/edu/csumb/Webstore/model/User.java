//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

public class User
{
    //Member variables
    private String id;
    private String name;
    private String password;
    private Cart cart;    
    

    //Default Contructor
    public User(){ }
    //Contructor
    public User(String name, String id, String password){
        this.name = name;
        this.id = id;
        this.password = password;
        cart = new Cart();
        cart.setOwner(name);
    }

    //Accessors
    public String getId() { return id; }
    public String getName(){ return name; }
    public Cart getCart(){ return cart; }
    public String getPassword(){ return password; }
    

    //Mutators
    public void setId(String id) { this.id = id; } 
    public void setaPassword(String password){ this.password = password;}
    public void setName(String name){ this.name = name; }
}