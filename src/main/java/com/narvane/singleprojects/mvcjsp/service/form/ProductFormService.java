package com.narvane.singleprojects.mvcjsp.service.form;

import com.narvane.singleprojects.mvcjsp.dto.product.ProductCategoryFormDTO;

import java.util.List;

public interface ProductFormService {

    /**
     * Load all categories to select in product
     * @return Product Categories Form DTOs
     */
    List<ProductCategoryFormDTO> loadAllCategories();

}
