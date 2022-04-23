package com.alkemy.icons.icons.repository;

import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.entity.IconEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ContinenteRepository extends JpaRepository<ContinenteEntity, Long>,JpaSpecificationExecutor<IconEntity>  {

	
}
