package com.javaguru.finalworkjavaguru.service;

import com.javaguru.finalworkjavaguru.repository.ProductRepository;
import com.javaguru.finalworkjavaguru.repository.entity.DiscountToSet;
import com.javaguru.finalworkjavaguru.repository.entity.Product;
import com.javaguru.finalworkjavaguru.repository.entity.ProductCategory;
import com.javaguru.finalworkjavaguru.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll()
                .forEach(products::add);
        return products;
    }

    public Product getProductById(long id) {
        return this.productRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    public void updateProduct(Product product) {
        Product productToUpdate = productRepository.findById(product.getId())
                .orElseThrow(NotFoundException::new);
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setCategory(product.getCategory());
        productToUpdate.setDiscount(product.getDiscount());
        productToUpdate.setDescription(product.getDescription());
        productRepository.save(productToUpdate);

    }

    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
    }

    public List<Product> getAllProductsByCategory(ProductCategory category) {
        return new ArrayList<>(productRepository.getAllByCategory(category));
    }

    public void setDiscountByProductCategory(ProductCategory category, DiscountToSet discountToSet) {
        productRepository.getAllByCategory(category)
                .stream()
                .peek(product -> product.updateDiscount(discountToSet))
                .map(productRepository::save)
                .count();
    }
}
