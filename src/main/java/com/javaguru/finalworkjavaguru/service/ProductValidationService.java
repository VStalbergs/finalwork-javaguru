package com.javaguru.finalworkjavaguru.service;

import com.javaguru.finalworkjavaguru.repository.entity.Product;

import java.math.BigDecimal;

public class ProductValidationService {

    public boolean validateProduct(Product product) {
        return validateName(product) && validatePrice(product) && validateCategory(product);
    }

    private boolean validateName(Product product) {
        return !(product.getName() == null || product.getName().equals(""));
    }

    private boolean validatePrice(Product product) {
        return !(product.getPrice() == null || product.getPrice().equals(new BigDecimal(0)));
    }

    private boolean validateCategory(Product product) {
        return !(product.getCategory() == null);
    }


}
