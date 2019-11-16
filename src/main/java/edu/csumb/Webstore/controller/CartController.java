//The controller file determines where someone can access your service.
//The controller shouldn't be doing any logic, and you should NEVER import the database into controller.
//Use the service for any logic, or even one line functions. 99 % of the time, the controller should only have
//the return statement, and nothing else!

package edu.csumb.Webstore.controller;

import java.util.Optional;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import edu.csumb.Webstore.model.Cart;
import edu.csumb.Webstore.repositories.ProductRepository;
import edu.csumb.Webstore.repositories.CartRepository;
import edu.csumb.Webstore.service.CartService;
import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@RestController
public class CartController
{

    @Autowired
    CartService cartService;

    // @RequestMapping(method = RequestMethod.GET, value = "/products/example")
    // @ApiOperation(value = "An example of a api function to get you started." )
    // public Iterable<String> example()
    // {
    //     //ALL LOGIC SHOULD BE IN THE SERVICE. EVEN IF IT'S JUST ONE LINE!
    //     //IF YOU HAVE ANY LOGIC IN THE CONTROLLER IT IS BAD!
    //     //So we are calling the service function we want.
    //     return productService.example();
    // }

    // Retrieving all products from services 
    @RequestMapping(value = "/cart/getAll", method= RequestMethod.GET)
    @ApiOperation(value = "An api function to get all products from the database." )
        public Iterable<Cart> getAllCarts() {
        return cartService.getAll();
    }
    
    @RequestMapping(method= RequestMethod.POST, value ="cart/addProduct")
    @ApiOperation(value = "Add new item to the cart of user")
    public void addCart(@RequestBody String username, String id, int amount){
        cartService.addToCart(username, id, amount);
    }
    @RequestMapping(method= RequestMethod.POST, value ="cart/update")
    @ApiOperation(value = "Update quantity of products")
    public void updateCart(@RequestBody String username, String id, int amount){
        cartService.updateCart(username, id, amount);
    }

    @RequestMapping(method= RequestMethod.POST, value ="cart/checkout")
    @ApiOperation(value = "Checkout and empty the cart of user")
    public void checkout(@RequestBody String username){
        cartService.checkout(username);
    }
    
    // Retrieving product by ID from services
    // @RequestMapping(value = "/cart/get/{id}", method = RequestMethod.GET)
    // @ApiOperation(value = "An api function to get a product from the database by its id." )
    // public Optional<Cart> getCartById(@PathVariable("id") String id) {
    //     return cartService.getCartById(id);
    // }
    // Adding products to 

}