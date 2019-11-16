//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import org.springframework.data.annotation.Id;

public class Product
{
    //member variables
    @Id
    private String id;
    private String name;
    private String description;
    private String imageURL;
    private Double price;
    private Integer stock;

    //Default Contructor
    public Product(){ }
    //Contructor
    public Product(String name, String id, String description, String imageURL, Double price, Integer quantity){
        this.name = name;
        this.id = id;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
        this.stock = quantity;
    }

    //Accessors
    public String getId() { return id; }
    public String getImageurl(){ return imageURL; }
    public String getName(){ return name; }
    public Double getPrice(){ return price; }
    public Integer getQuantity(){ return stock; }
    public String getDescription(){ return description; }
    
    //Mutators
    public void setId(String id) { this.id = id; }
    public void setImageurl(String imageURl){ this.imageURL = imageURl; }
    public void setName(String name){ this.name = name; }
    public void setPrice(Double price){ this.price = price; }
    public void setStock(Integer quantity){ this.stock = quantity; }
    public void setDescription(String description){ this.description = description; }
}