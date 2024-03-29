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
import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.repositories.ProductRepository;
import edu.csumb.Webstore.service.ProductService;
import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@RestController
public class ProductController
{

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/products/example")
    @ApiOperation(value = "An example of a api function to get you started." )
    public Iterable<String> example()
    {
        //ALL LOGIC SHOULD BE IN THE SERVICE. EVEN IF IT'S JUST ONE LINE!
        //IF YOU HAVE ANY LOGIC IN THE CONTROLLER IT IS BAD!
        //So we are calling the service function we want.
        return productService.example();
    }

    // Retrieving all products from services 
    @RequestMapping(value = "/products/getAll", method= RequestMethod.GET)
        public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    // Retrieving product by ID from services
    @RequestMapping(value = "/products/get/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") String id) {
        return productService.getbyID(id);
    }
    // Adding products to 
    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public Product createProduct(@Valid @RequestBody Product prod) {
        return productService.createProd(prod);
    }
    


}