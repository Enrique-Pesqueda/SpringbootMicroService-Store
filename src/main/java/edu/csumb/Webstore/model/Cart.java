//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import java.util.HashMap;

public class Cart
{

    //member variables
    private String owner;    
    private HashMap<String, Integer> map;

    //Default Contructor
    public Cart(){ 
        map = new HashMap<>();
    }
    
    //Mutators
    public void setOwner(String owner){ this.owner= owner; }
    
    //Accessors
    public String getOwner(){ return owner; }
    public int getById(String id){ return map.get(id); }
    
    //Member Functions
    public void addCart(String id, int quantity){ map.put(id, quantity); }
    public void removeAll(){ map.clear(); }
    public void update(String id, int quantity) {
        map.put(id, quantity);
        if( map.get(id)== 0){
            map.remove(id);
        }
    }
}