package io.github.vikie1.whatsoftware.repository;

import io.github.vikie1.whatsoftware.entity.NestedCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NestedCategoryRepository extends JpaRepository<NestedCategoryEntity, Long> {
    List<NestedCategoryEntity> findAllByCatNameAllIgnoreCase(String catName);
    NestedCategoryEntity findBySoftwareAllIgnoreCase(String software);
    List<NestedCategoryEntity> findAllByParentCategoryAllIgnoreCase(String parentCategory);
    NestedCategoryEntity findByNestedCategoryAllIgnoreCase(String nestedCategory);
    boolean existsBySoftwareAllIgnoreCase(String software);
    void deleteBySoftwareAllIgnoreCase(String software);
}
