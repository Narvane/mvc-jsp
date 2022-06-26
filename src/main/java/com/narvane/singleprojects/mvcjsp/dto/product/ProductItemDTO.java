package com.narvane.singleprojects.mvcjsp.dto.product;

import com.narvane.singleprojects.mvcjsp.dto.GenericDTO;
import com.narvane.singleprojects.mvcjsp.model.Product;

import java.math.BigDecimal;

public class ProductItemDTO extends GenericDTO<Product> {

    private String id;

    private String name;

    private String category;

    private BigDecimal value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public ProductItemDTO fromEntity(Product product) {
        this.id = product.getId().toString();
        this.name = product.getName();
        this.value = product.getValue();
        if (product.getCategory() != null) this.category = product.getCategory().getName();
        return this;
    }

}
