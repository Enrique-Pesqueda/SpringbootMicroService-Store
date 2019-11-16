//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.Cart;
import edu.csumb.Webstore.repositories.CartRepository;

//Remember to annotate what type of class this is!
@Service
public class CartService
{
    //We need to autowire the database here. If you are stuck, look at ProductController!
    @Autowired
    CartRepository cartRepo;

    // private List<Product> prodList = new ArrayList<Product>();
    //We need to autowire the database here. If you are stuck, look at ProductController!
    // public Iterable<String> example()
    // {
    //     List<String> sList = new ArrayList<>();
    //     sList.add("Cameron is such a good TA, i'm going to give him 5 stars on every review!");
    //     return sList;
    // }



    public List<Cart> getAll(){
        return cartRepo.findAll();
    }    
    public Optional<Cart> getCartById(String id) throws IllegalArgumentException {
        return cartRepo.findById(id);
    }
    public Cart createCart(Cart cart){
        cartRepo.insert(cart);
        return cart;
    }

    public boolean checkout(String username){
        List<Cart>carts = cartRepo.findAll();
        for(Cart i : carts){
            if(i.getOwner().equals(username)){
                i.removeAll();
                return true;
            }
        }
        return false;
    }
    public void addToCart(String username, String id, int amount) {
        List<Cart>carts = cartRepo.findAll();
        for( Cart i : carts){
            if(i.getOwner().equals(username)){
                i.addCart(id, amount);
            }
        }
    }
    
    public void updateCart(String username, String id, int amount) {
        List<Cart>carts = cartRepo.findAll();
        for( Cart i : carts){
            if(i.getOwner().equals(username)){
                i.update(id, amount);
            }
        }
    
    }
    public Cart listCart(String username){
        List<Cart>carts = cartRepo.findAll();
        for( Cart i : carts){
            if(i.getOwner().equals(username)){
                return i;
            }
        }
        return new Cart();
    }


}