package com.narvane.singleprojects.mvcjsp.controller;


import com.narvane.singleprojects.mvcjsp.dto.product.ProductFormDTO;
import com.narvane.singleprojects.mvcjsp.model.Product;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface ProductController extends GenericController<Product> {

    /**
     * Show product's form for a new one
     * @return Empty Product and available categories form DTOs
     */
    String showNewProductView(Model model);

    /**
     * Show product's form for an existent one
     * @param id Existent product ID
     * @return Filled product with available categories form DTOs
     */
    String showUpdateProductView(String id, Model model);

    /**
     * Create a new product
     * @param productDTO Form DTO for product
     * @return Redirect to products listing
     */
    String createProduct(ProductFormDTO productDTO);

    /**
     * Update an existent product
     * @param productDTO Form DTO for product
     * @return Redirect to products listing
     */
    String updateProduct(ProductFormDTO productDTO);

    /**
     * Products listing
     * @return Product DTO items and product listing view
     */
    ModelAndView listProducts();

    /**
     * Delete a product by its ID
     * @param id Product id
     * @return Redirect to products listing
     */
    String deleteProduct(String id);

}
