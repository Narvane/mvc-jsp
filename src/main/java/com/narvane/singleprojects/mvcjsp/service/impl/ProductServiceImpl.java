package com.narvane.singleprojects.mvcjsp.service.impl;

import com.narvane.singleprojects.mvcjsp.model.Product;
import com.narvane.singleprojects.mvcjsp.repository.GenericRepository;
import com.narvane.singleprojects.mvcjsp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product> implements ProductService {

    @Autowired
    protected ProductServiceImpl(GenericRepository<Product> genericRepository) {
        super(genericRepository);
    }

    @Override
    public void newProduct(Product product) {
        getRepository().save(product);
    }


}
