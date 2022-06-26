package com.narvane.singleprojects.mvcjsp.service.form;

import com.narvane.singleprojects.mvcjsp.dto.product.ProductItemDTO;

import java.util.List;

public interface ProductListService {

    /**
     * Load the product list
     * @return Product Items DTOs
     */
    List<ProductItemDTO> loadAllProducts();

}
