package com.narvane.singleprojects.mvcjsp.dto;

public abstract class GenericDTO<Entity> {

    public GenericDTO<Entity> fromEntity(Entity entity) {
        return null;
    }

    public Entity toEntity() {
        return null;
    }

}
