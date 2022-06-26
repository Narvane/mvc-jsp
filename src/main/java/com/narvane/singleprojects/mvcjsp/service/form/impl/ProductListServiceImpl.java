package com.narvane.singleprojects.mvcjsp.service.form.impl;

import com.narvane.singleprojects.mvcjsp.dto.product.ProductItemDTO;
import com.narvane.singleprojects.mvcjsp.model.Product;
import com.narvane.singleprojects.mvcjsp.service.ProductService;
import com.narvane.singleprojects.mvcjsp.service.form.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductListServiceImpl implements ProductListService {

    private final ProductService productService;

    @Autowired
    public ProductListServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    public List<ProductItemDTO> loadAllProducts() {
        List<Product> products = productService.findAll();

        return products.stream().map(
                product -> new ProductItemDTO().fromEntity(product)
        ).collect(Collectors.toList());
    }

}
