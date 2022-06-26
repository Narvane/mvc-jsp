package com.narvane.singleprojects.mvcjsp.dto.product;

import com.narvane.singleprojects.mvcjsp.dto.GenericDTO;
import com.narvane.singleprojects.mvcjsp.model.Category;
import com.narvane.singleprojects.mvcjsp.model.Product;

import java.math.BigDecimal;
import java.util.UUID;

import static io.micrometer.core.instrument.util.StringUtils.*;

// TODO Validations
public class ProductFormDTO extends GenericDTO<Product> {

    private String id;

    private String name;

    private BigDecimal value;

    private String categoryId;

    public Product toEntity() {

        Product product = new Product();
        product.setName(this.name);
        product.setValue(value);
        product.setId(isNotBlank(id) ? UUID.fromString(id) : null);
        if (isNotBlank(categoryId)) product.setCategory(new Category(UUID.fromString(categoryId)));
        return product;
    }

    @Override
    public ProductFormDTO fromEntity(Product product) {
        this.id = product.getId().toString();
        this.name = product.getName();
        this.value = product.getValue();
        this.categoryId = product.getCategory().getId().toString();
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
