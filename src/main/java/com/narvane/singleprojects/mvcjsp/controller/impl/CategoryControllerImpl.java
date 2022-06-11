package com.narvane.singleprojects.mvcjsp.controller.impl;

import com.narvane.singleprojects.mvcjsp.controller.CategoryController;
import com.narvane.singleprojects.mvcjsp.dto.RegisterCategoryDTO;
import com.narvane.singleprojects.mvcjsp.model.Category;
import com.narvane.singleprojects.mvcjsp.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("category")
public class CategoryControllerImpl extends GenericControllerImpl<Category> implements CategoryController {

    @Autowired
    public CategoryControllerImpl(GenericService<Category> service) {
        super(service);
    }

    @Override
    @GetMapping("new")
    public String newCategoryView(Model model) {

        model.addAttribute("category", new Category());
        return "category/newCategory";
    }

    @Override
    @PostMapping("new")
    public String registerCategory(@ModelAttribute("category") RegisterCategoryDTO categoryDTO) {
        getService().save(categoryDTO.toEntity());

        return "category/newCategory";
    }

}
