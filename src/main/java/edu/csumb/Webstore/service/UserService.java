//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.repositories.ProductRepository;

//Remember to annotate what type of class this is!
@Service
public class UserService
{
    //We need to autowire the database here. If you are stuck, look at UserController!
    private List<User> userList = new ArrayList<User>();

    //We need to autowire the database here. If you are stuck, look at UserController!
    public Iterable<String> example()
    {
        List<String> sList = new ArrayList<>();
        sList.add("Cameron is such a good TA, i'm going to give him 5 stars on every review!");
        return sList;
    }

    public List<User> getAllUsers(){
        return userList;
    }
    
    public User getbyID(String id){
        for (int i = 0; i < userList.size(); i++) {
            User a = userList.get(i);
            if(a.getId().equals(id)){
                return a;
            }
        }
        return null;
    }
    
    public User createUser(User prod){
        userList.add(prod);
        return prod;
    }
}