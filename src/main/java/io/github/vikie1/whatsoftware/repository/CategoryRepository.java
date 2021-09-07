package io.github.vikie1.whatsoftware.repository;

import io.github.vikie1.whatsoftware.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByCatNameAllIgnoreCase(String catName);
    CategoryEntity findBySoftwareAllIgnoreCase(String software);
}
