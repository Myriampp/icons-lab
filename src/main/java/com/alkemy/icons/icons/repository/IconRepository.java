package com.alkemy.icons.icons.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.alkemy.icons.icons.entity.IconEntity;

@Repository
public interface IconRepository extends JpaRepository<IconEntity, Long>, JpaSpecificationExecutor<IconEntity> {

List<IconEntity> findAll(Specification<IconEntity> spec);
}




