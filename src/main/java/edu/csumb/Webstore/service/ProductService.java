//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.repositories.ProductRepository;

//Remember to annotate what type of class this is!
@Service
public class ProductService
{
    //We need to autowire the database here. If you are stuck, look at ProductController!
    private List<Product> prodList = new ArrayList<Product>();

    //We need to autowire the database here. If you are stuck, look at ProductController!
    public Iterable<String> example()
    {
        List<String> sList = new ArrayList<>();
        sList.add("Cameron is such a good TA, i'm going to give him 5 stars on every review!");
        return sList;
    }

    public List<Product> getAllProducts(){
        return prodList;
    }
    
    public Product getbyID(String id){
        for (int i = 0; i < prodList.size(); i++) {
            Product a = prodList.get(i);
            if(a.getId().equals(id)){
                return a;
            }
        }
        return null;
    }

    
    public Product createProd(Product prod){
        prodList.add(prod);
        return prod;
    }

    
}