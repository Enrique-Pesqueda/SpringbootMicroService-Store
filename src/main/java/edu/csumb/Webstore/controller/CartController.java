//The controller file determines where someone can access your service.
//The controller shouldn't be doing any logic, and you should NEVER import the database into controller.
//Use the service for any logic, or even one line functions. 99 % of the time, the controller should only have
//the return statement, and nothing else!

package edu.csumb.Webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import edu.csumb.Webstore.model.Cart;
import edu.csumb.Webstore.service.CartService;

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
    @ApiOperation(value = "An api function to get all carts from the database." )
        public Iterable<Cart> getAllCarts() {
        return cartService.getAll();
    }
    
    @RequestMapping(value ="/cart/addProduct", method= RequestMethod.POST)
    @ApiOperation(value = "An api function that adds a new item to the cart for the user")
    public void addCart(@RequestBody String username, String id, int amount){
        cartService.addToCart(username, id, amount);
    }
    @RequestMapping(value ="/cart/update", method= RequestMethod.POST)
    @ApiOperation(value = "Update the amount of items in cart")
    public void updateCart(@RequestBody String username, String id, int amount){
        cartService.updateCart(username, id, amount);
    }

    @RequestMapping(value ="/cart/checkout", method= RequestMethod.POST)
    @ApiOperation(value = "Checkout and empty the cart of user")
    public void checkout(@RequestBody String username){
        cartService.checkout(username);
    }

}