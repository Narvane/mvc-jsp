package com.narvane.singleprojects.mvcjsp.dto.category;

import com.narvane.singleprojects.mvcjsp.dto.GenericDTO;
import com.narvane.singleprojects.mvcjsp.model.Category;

// TODO Validations
public class CategoryFormDTO extends GenericDTO<Category> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Category toEntity() {
        Category category = new Category();
        category.setName(this.name);
        return category;
    }
}
