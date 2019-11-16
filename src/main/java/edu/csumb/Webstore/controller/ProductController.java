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
import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.service.ProductService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ProductController
{

    @Autowired
    ProductService productService;

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
    @RequestMapping(value = "/products/getAll", method= RequestMethod.GET)
    @ApiOperation(value = "An api function to get all products from the database." )
        public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    // Retrieving product by ID from services
    @RequestMapping(value = "/products/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "An api function to get a product from the database by its id." )
    public Optional<Product> getProductById(@PathVariable("id") String id) {
        return productService.getProductById(id);
    }
    // Adding products to 
    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    @ApiOperation(value = "An api function to add products to the database." )
    public Product createProduct(@Valid @RequestBody Product prod) {
        return productService.createProd(prod);
    }
    


}