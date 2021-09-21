package io.github.vikie1.whatsoftware.repository;

import io.github.vikie1.whatsoftware.entity.CategoryEntity;
import io.github.vikie1.whatsoftware.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
    List<TypeEntity> findAllByCategoryEntity(CategoryEntity categoryEntity);
    List<TypeEntity> findAllByNestedCategoryEntity(NestedCategoryEntity nestedCategoryEntity);
    TypeEntity findByTypeAllIgnoreCase(String type);
    boolean existsByTypeAllIgnoreCase(String type);
}
