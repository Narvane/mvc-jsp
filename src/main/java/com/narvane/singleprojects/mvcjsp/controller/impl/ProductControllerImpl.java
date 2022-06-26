package com.narvane.singleprojects.mvcjsp.controller.impl;

import com.narvane.singleprojects.mvcjsp.controller.ProductController;
import com.narvane.singleprojects.mvcjsp.dto.product.ProductFormDTO;
import com.narvane.singleprojects.mvcjsp.model.Product;
import com.narvane.singleprojects.mvcjsp.service.GenericService;
import com.narvane.singleprojects.mvcjsp.service.form.ProductFormService;
import com.narvane.singleprojects.mvcjsp.service.form.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("product")
public class ProductControllerImpl extends GenericControllerImpl<Product> implements ProductController {

    private static final String PRODUCT_FORM_VIEW = "product/form";
    private static final String PRODUCT_LIST_VIEW = "product/list";
    private static final String REDIRECT_PRODUCT_LIST = "redirect:/product/all";

    private final ProductFormService formService;
    private final ProductListService listService;

    @Autowired
    public ProductControllerImpl(@Qualifier("productServiceImpl") GenericService<Product> service,
                                 ProductFormService formService, ProductListService listService) {
        super(service);
        this.formService = formService;
        this.listService = listService;
    }

    @GetMapping("new")
    public String showNewProductView(Model model) {

        model.addAttribute("product", new ProductFormDTO());
        model.addAttribute("categories", formService.loadAllCategories());

        return PRODUCT_FORM_VIEW;
    }

    @GetMapping("update")
    public String showUpdateProductView(@RequestParam("id") String id, Model model) {

        model.addAttribute("product", new ProductFormDTO().fromEntity(getService().findById(UUID.fromString(id))));
        model.addAttribute("categories", formService.loadAllCategories());

        return PRODUCT_FORM_VIEW;
    }

    @PostMapping("new")
    public String createProduct(@ModelAttribute("product") ProductFormDTO productDTO) {
        getService().save(productDTO.toEntity());

        return REDIRECT_PRODUCT_LIST;
    }

    @PostMapping("update")
    public String updateProduct(ProductFormDTO productDTO) {

        getService().save(productDTO.toEntity());

        return REDIRECT_PRODUCT_LIST;
    }

    @Override
    @GetMapping("all")
    public ModelAndView listProducts() {
        ModelAndView modelAndView = new ModelAndView(PRODUCT_LIST_VIEW);
        modelAndView.addObject("products", listService.loadAllProducts());
        return modelAndView;
    }

    @Override
    @GetMapping("delete")
    public String deleteProduct(@RequestParam("id") String id) {
        getService().deleteById(UUID.fromString(id));

        return REDIRECT_PRODUCT_LIST;
    }

}
