package com.narvane.singleprojects.mvcjsp.controller;

import com.narvane.singleprojects.mvcjsp.service.GenericService;

public interface GenericController<Entity> {

    GenericService<Entity> getService();

}
