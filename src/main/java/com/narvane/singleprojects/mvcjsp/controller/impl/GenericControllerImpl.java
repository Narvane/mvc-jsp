package com.narvane.singleprojects.mvcjsp.controller.impl;

import com.narvane.singleprojects.mvcjsp.controller.GenericController;
import com.narvane.singleprojects.mvcjsp.service.GenericService;

public abstract class GenericControllerImpl<Entity> implements GenericController<Entity> {

    private GenericService<Entity> service;

    public GenericControllerImpl(GenericService<Entity> service) {
        this.service = service;
    }

    @Override
    public GenericService<Entity> getService() {
        return service;
    }

}
