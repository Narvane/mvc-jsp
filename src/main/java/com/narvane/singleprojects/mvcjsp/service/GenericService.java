package com.narvane.singleprojects.mvcjsp.service;

import com.narvane.singleprojects.mvcjsp.repository.GenericRepository;

import java.util.List;
import java.util.UUID;

public interface GenericService<Entity> {

    GenericRepository<Entity> getRepository();

    Entity save(Entity entity);

    List<Entity> findAll();

    Entity findById(UUID uuid);

    void deleteById(UUID uuid);

}
