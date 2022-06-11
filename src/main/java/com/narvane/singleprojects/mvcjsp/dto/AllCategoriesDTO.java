package com.narvane.singleprojects.mvcjsp.dto;

import com.narvane.singleprojects.mvcjsp.model.Category;

public class AllCategoriesDTO extends GenericDTO<Category> {

    private String id;

    private String name;

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

    @Override
    public AllCategoriesDTO fromEntity(Category category) {
        this.id = category.getId().toString();
        this.name = category.getName();
        return this;
    }

}
