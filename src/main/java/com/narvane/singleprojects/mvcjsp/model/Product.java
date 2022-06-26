package com.narvane.singleprojects.mvcjsp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tbl_product")
public class Product extends EntityWithUUID {

    private String name;

    // TODO Set default value to 0.0
    private BigDecimal value;

    @ManyToOne
    private Category category;

    public Product() {}

    public Product(UUID id) {
        super(id);
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
