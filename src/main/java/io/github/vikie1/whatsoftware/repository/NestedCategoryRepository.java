package io.github.vikie1.whatsoftware.repository;

import io.github.vikie1.whatsoftware.entity.NestedCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NestedCategoryRepository extends JpaRepository<NestedCategoryEntity, Long> {
    NestedCategoryEntity findByCatNameAllIgnoreCase(String catName);
    NestedCategoryEntity findBySoftwareAllIgnoreCase(String software);
}
