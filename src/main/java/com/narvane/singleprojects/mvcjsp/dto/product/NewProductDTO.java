package com.narvane.singleprojects.mvcjsp.dto.product;

import com.narvane.singleprojects.mvcjsp.dto.GenericDTO;
import com.narvane.singleprojects.mvcjsp.model.Category;
import com.narvane.singleprojects.mvcjsp.model.Product;
import io.micrometer.core.instrument.util.StringUtils;

import java.math.BigDecimal;
import java.util.UUID;

import static io.micrometer.core.instrument.util.StringUtils.*;

public class NewProductDTO extends GenericDTO<Product> {

    private String name;

    private BigDecimal value;

    private String categoryId;

    public Product toEntity() {

        Product product = new Product();
        product.setName(this.name);
        product.setValue(value);
        if (isNotBlank(categoryId)) product.setCategory(new Category(UUID.fromString(categoryId)));
        return product;
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
}
