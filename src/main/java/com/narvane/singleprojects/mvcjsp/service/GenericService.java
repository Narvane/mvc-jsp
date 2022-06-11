package com.narvane.singleprojects.mvcjsp.service;

import com.narvane.singleprojects.mvcjsp.repository.GenericRepository;

import java.util.List;

public interface GenericService<Entity> {

    GenericRepository<Entity> getRepository();

    Entity save(Entity entity);

    List<Entity> findAll();

}
