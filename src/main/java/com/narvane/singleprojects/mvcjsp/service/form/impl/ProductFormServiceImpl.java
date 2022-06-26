package com.narvane.singleprojects.mvcjsp.service.form.impl;

import com.narvane.singleprojects.mvcjsp.dto.product.ProductCategoryFormDTO;
import com.narvane.singleprojects.mvcjsp.model.Category;
import com.narvane.singleprojects.mvcjsp.service.CategoryService;
import com.narvane.singleprojects.mvcjsp.service.form.ProductFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductFormServiceImpl implements ProductFormService {

    private final CategoryService categoryService;

    @Autowired
    public ProductFormServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public List<ProductCategoryFormDTO> loadAllCategories() {
        List<Category> categories = categoryService.findAll();

        return categories.stream().map(
                category -> new ProductCategoryFormDTO().fromEntity(category)
        ).collect(Collectors.toList());
    }

}
