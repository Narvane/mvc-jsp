package com.narvane.singleprojects.mvcjsp.dto;

import com.narvane.singleprojects.mvcjsp.model.Product;

public class RegisterProductDTO {

    private String name;

    public Product toProduct() {

        Product product = new Product();
        product.setName(name);
        return product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
