package com.javaguru.finalworkjavaguru.controller;


import com.javaguru.finalworkjavaguru.repository.entity.DiscountToSet;
import com.javaguru.finalworkjavaguru.repository.entity.Product;
import com.javaguru.finalworkjavaguru.repository.entity.ProductCategories;
import com.javaguru.finalworkjavaguru.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProductById(@PathVariable("id") long id) {
        productService.deleteProductById(id);
    }

    @RequestMapping(value = "/categories/{category}", method = RequestMethod.GET)
    public List<Product> getAllProductsByCategory(@PathVariable("category") ProductCategories category) {
        return productService.getAllProductsByCategory(category);
    }

    @RequestMapping(value = "/categories/{category}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setDiscountByProductCategory(@PathVariable("category") ProductCategories category, @RequestBody DiscountToSet discountToSet) {
        productService.setDiscountByProductCategory(category, discountToSet);
    }
}
