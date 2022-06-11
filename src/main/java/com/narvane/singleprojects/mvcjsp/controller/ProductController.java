package com.narvane.singleprojects.mvcjsp.controller;


import com.narvane.singleprojects.mvcjsp.dto.RegisterProductDTO;
import com.narvane.singleprojects.mvcjsp.model.Product;
import org.springframework.ui.Model;

public interface ProductController extends GenericController<Product> {

    String newProductView(Model model);

    String registerProduct(RegisterProductDTO productDTO);

}
