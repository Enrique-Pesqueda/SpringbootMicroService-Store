//The controller file determines where someone can access your service.
//The controller shouldn't be doing any logic, and you should NEVER import the database into controller.
//Use the service for any logic, or even one line functions. 99 % of the time, the controller should only have
//the return statement, and nothing else!

package edu.csumb.Webstore.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.service.UserService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserController
{

    @Autowired
    UserService userService;

    // @RequestMapping(method = RequestMethod.GET, value = "/products/example")
    // @ApiOperation(value = "An example of a api function to get you started." )
    // public Iterable<String> example()
    // {
    //     //ALL LOGIC SHOULD BE IN THE SERVICE. EVEN IF IT'S JUST ONE LINE!
    //     //IF YOU HAVE ANY LOGIC IN THE CONTROLLER IT IS BAD!
    //     //So we are calling the service function we want.
    //     return productService.example();
    // }

    // Retrieving all users from services 
    @RequestMapping(value = "/users/getAll", method= RequestMethod.GET)
    @ApiOperation(value = "An api function to get all users from the database." )
        public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }
    // Retrieving user by ID from services
    @RequestMapping(value = "/users/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "An api function to get a user from the database by its id." )
    public Optional<User> getUserById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }
    // Adding users to 
    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    @ApiOperation(value = "An api function to add users to the database." )
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
}