package com.javaguru.finalworkjavaguru.repository.entity;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
@Entity
@Validated
public class Product {

    @Id
    @GeneratedValue
    private long id;

    @NotEmpty(message = "{name.notEmpty}")
    private String name;

    @NotEmpty(message = "{price.notNull}")
    private BigDecimal price;

    @NotNull(message = "{category.notNull}")
    @Enumerated(value = EnumType.STRING)
    private ProductCategory category;

    private BigDecimal discount;
    private String description;

    public void updateDiscount(DiscountToSet discountToSet) {
        discount = discountToSet.getDiscount();
    }
}
