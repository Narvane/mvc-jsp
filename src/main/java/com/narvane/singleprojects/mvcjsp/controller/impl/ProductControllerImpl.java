package com.narvane.singleprojects.mvcjsp.controller.impl;

import com.narvane.singleprojects.mvcjsp.controller.ProductController;
import com.narvane.singleprojects.mvcjsp.dto.product.ListProductDTO;
import com.narvane.singleprojects.mvcjsp.dto.product.NewProductCategoryDTO;
import com.narvane.singleprojects.mvcjsp.dto.product.NewProductDTO;
import com.narvane.singleprojects.mvcjsp.model.Category;
import com.narvane.singleprojects.mvcjsp.model.Product;
import com.narvane.singleprojects.mvcjsp.service.CategoryService;
import com.narvane.singleprojects.mvcjsp.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;
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

        model.addAttribute("product", new NewProductDTO());
        model.addAttribute("categories", loadCategories());

        return "product/newProduct";
    }

    @GetMapping("update")
    public String updateProductView(@RequestParam("id") String id, Model model) {

        model.addAttribute("product", new NewProductDTO().fromEntity(getService().findById(UUID.fromString(id))));
        model.addAttribute("categories", loadCategories());

        return "product/newProduct";
    }

    @PostMapping("update")
    public String updateProduct(NewProductDTO productDTO) {

        getService().save(productDTO.toEntity());

        return "redirect:/product/all";
    }

    @PostMapping("new")
    public String registerProduct(@ModelAttribute("product") NewProductDTO productDTO) {
        getService().save(productDTO.toEntity());

        return "redirect:/product/all";
    }

    @Override
    @GetMapping("all")
    public ModelAndView allProducts() {
        ModelAndView modelAndView = new ModelAndView("product/allProducts");
        modelAndView.addObject("products", loadProducts());
        return modelAndView;
    }

    @Override
    @GetMapping("delete")
    public String deleteProduct(@RequestParam("id") String id) {
        getService().deleteById(UUID.fromString(id));

        return "redirect:/product/all";
    }

    private List<ListProductDTO> loadProducts() {
        List<Product> products = getService().findAll();

        return products.stream().map(
                product -> new ListProductDTO().fromEntity(product)
        ).collect(Collectors.toList());
    }

    private List<NewProductCategoryDTO> loadCategories() {
        List<Category> categories = categoryService.findAll();

        return categories.stream().map(
                category -> new NewProductCategoryDTO().fromEntity(category)
        ).collect(Collectors.toList());
    }

}
