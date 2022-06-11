package com.narvane.singleprojects.mvcjsp.dto;

import com.narvane.singleprojects.mvcjsp.model.Category;

public class RegisterCategoryDTO extends GenericDTO<Category> {

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
