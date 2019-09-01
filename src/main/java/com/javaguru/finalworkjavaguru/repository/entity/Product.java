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

    @NotNull(message = "{price.notNull}")
    private BigDecimal price = new BigDecimal("0");

    @NotNull(message = "{category.notNull}")
    @Enumerated(value = EnumType.STRING)
    private ProductCategory category;

    private BigDecimal discount= new BigDecimal("0");
    private BigDecimal actualPrice = calculateActualPrice();
    private String description;



    private BigDecimal calculateActualPrice (){
        BigDecimal oneHundred = new BigDecimal("100");
        BigDecimal differenceForCalculation = oneHundred.subtract(discount).divide(oneHundred, 2);
        return getPrice().multiply(differenceForCalculation);
    }

    public void updateDiscount(DiscountToSet discountToSet) {
        discount = discountToSet.getDiscount();
    }
}
