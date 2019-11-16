//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.repositories.UserRepository;

//Remember to annotate what type of class this is!
@Service
public class UserService
{
    //We need to autowire the database here. If you are stuck, look at ProductController!
    @Autowired
    UserRepository userRepo;

    // private List<Product> prodList = new ArrayList<Product>();
    //We need to autowire the database here. If you are stuck, look at ProductController!
    // public Iterable<String> example()
    // {
    //     List<String> sList = new ArrayList<>();
    //     sList.add("Cameron is such a good TA, i'm going to give him 5 stars on every review!");
    //     return sList;
    // }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }    
    public Optional<User> getUserById(String id) throws IllegalArgumentException {
        return userRepo.findById(id);
    }
    public User createUser(User user){
        userRepo.insert(user);
        return user;
    }

    public boolean auth(String name, String pass){
        List<User>users = userRepo.findAll();
        for(User i : users){
            if(i.getName().equals(name) && i.getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
    

    
}