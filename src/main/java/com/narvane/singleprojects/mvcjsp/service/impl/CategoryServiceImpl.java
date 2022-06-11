package com.narvane.singleprojects.mvcjsp.service.impl;

import com.narvane.singleprojects.mvcjsp.model.Category;
import com.narvane.singleprojects.mvcjsp.repository.GenericRepository;
import com.narvane.singleprojects.mvcjsp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category> implements CategoryService {

    @Autowired
    protected CategoryServiceImpl(GenericRepository<Category> genericRepository) {
        super(genericRepository);
    }

}
