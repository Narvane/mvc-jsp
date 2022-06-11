package com.narvane.singleprojects.mvcjsp.dto;

import com.narvane.singleprojects.mvcjsp.model.Product;

public class RegisterProductDTO extends GenericDTO<Product> {

    private String name;

    public Product toEntity() {

        Product product = new Product();
        product.setName(this.name);
        return product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
