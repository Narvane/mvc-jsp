package com.narvane.singleprojects.mvcjsp.controller;

import com.narvane.singleprojects.mvcjsp.dto.category.CategoryFormDTO;
import org.springframework.ui.Model;

public interface CategoryController {

    /**
     * Show category's form for a new one
     * @return Empty category
     */
    String showNewCategoryView(Model model);

    /**
     * Create a new category
     * @param categoryDTO Form DTO for category
     * @return Redirect to categories listing
     */
    String createCategory(CategoryFormDTO categoryDTO);

}
