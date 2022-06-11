package com.narvane.singleprojects.mvcjsp.controller.impl;

import com.narvane.singleprojects.mvcjsp.controller.ProductController;
import com.narvane.singleprojects.mvcjsp.dto.AllCategoriesDTO;
import com.narvane.singleprojects.mvcjsp.dto.RegisterProductDTO;
import com.narvane.singleprojects.mvcjsp.model.Category;
import com.narvane.singleprojects.mvcjsp.model.Product;
import com.narvane.singleprojects.mvcjsp.service.CategoryService;
import com.narvane.singleprojects.mvcjsp.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("product")
public class ProductControllerImpl extends GenericControllerImpl<Product> implements ProductController {

    private final CategoryService categoryService;

    @Autowired
    public ProductControllerImpl(@Qualifier("productServiceImpl") GenericService<Product> service,
                                 CategoryService categoryService) {
        super(service);
        this.categoryService = categoryService;
    }

    @GetMapping("new")
    public String newProductView(Model model) {

        model.addAttribute("product", new Product());
        model.addAttribute("categories", loadCategories());

        return "product/newProduct";
    }

    @PostMapping("new")
    public String registerProduct(@ModelAttribute("product") RegisterProductDTO productDTO) {
        getService().save(productDTO.toEntity());

        return "product/newProduct";
    }

    private List<AllCategoriesDTO> loadCategories() {
        List<Category> categories = categoryService.findAll();

        return categories.stream().map(
                category -> new AllCategoriesDTO().fromEntity(category)
        ).collect(Collectors.toList());
    }

}
