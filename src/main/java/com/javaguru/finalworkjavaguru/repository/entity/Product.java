package com.javaguru.finalworkjavaguru.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private BigDecimal price;
    @Enumerated(value = EnumType.STRING)
    private ProductCategories category;
    private BigDecimal discount;
    private String description;

    public void updateDiscount(DiscountToSet discountToSet) {
        discount = discountToSet.getDiscount();
    }
}
