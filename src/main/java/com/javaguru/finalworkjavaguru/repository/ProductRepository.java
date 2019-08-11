package com.javaguru.finalworkjavaguru.repository;

import com.javaguru.finalworkjavaguru.repository.entity.Product;
import com.javaguru.finalworkjavaguru.repository.entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> getAllByCategory(ProductCategory category);
}
