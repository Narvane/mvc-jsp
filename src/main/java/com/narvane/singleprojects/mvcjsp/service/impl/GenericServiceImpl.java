package com.narvane.singleprojects.mvcjsp.service.impl;

import com.narvane.singleprojects.mvcjsp.repository.GenericRepository;
import com.narvane.singleprojects.mvcjsp.service.GenericService;

import java.util.List;
import java.util.UUID;

public abstract class GenericServiceImpl<Entity> implements GenericService<Entity> {

    private final GenericRepository<Entity> genericRepository;

    protected GenericServiceImpl(GenericRepository<Entity> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Override
    public GenericRepository<Entity> getRepository() {
        return genericRepository;
    }

    @Override
    public Entity save(Entity entity) {
        return getRepository().save(entity);
    }

    @Override
    public List<Entity> findAll() {
        return getRepository().findAll();
    }

    @Override
    public Entity findById(UUID uuid) {
        //TODO Exception Handler
        return getRepository().findById(uuid).get();
    }

    @Override
    public void deleteById(UUID uuid) {
        getRepository().deleteById(uuid);
    }

}
