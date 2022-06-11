package com.narvane.singleprojects.mvcjsp.controller.impl;

import com.narvane.singleprojects.mvcjsp.controller.ProductController;
import com.narvane.singleprojects.mvcjsp.dto.RegisterProductDTO;
import com.narvane.singleprojects.mvcjsp.model.Product;
import com.narvane.singleprojects.mvcjsp.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductControllerImpl extends GenericControllerImpl<Product> implements ProductController {

    @Autowired
    public ProductControllerImpl(GenericService<Product> service) {
        super(service);
    }

    @GetMapping("new")
    public String newProductView(Model model) {
        model.addAttribute("product", new Product());
        return "product/newProduct";
    }

    @PostMapping("new")
    public String registerProduct(@ModelAttribute("product") RegisterProductDTO productDTO) {
        getService().save(productDTO.toProduct());

        return "product/newProduct";
    }
}
