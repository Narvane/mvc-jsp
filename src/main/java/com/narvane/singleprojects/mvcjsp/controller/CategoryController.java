package com.narvane.singleprojects.mvcjsp.controller;

import com.narvane.singleprojects.mvcjsp.dto.RegisterCategoryDTO;
import org.springframework.ui.Model;

public interface CategoryController {

    String newCategoryView(Model model);

    String registerCategory(RegisterCategoryDTO categoryDTO);

}
