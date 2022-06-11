package com.narvane.singleprojects.mvcjsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface GenericRepository<Entity> extends JpaRepository<Entity, UUID> {

}
