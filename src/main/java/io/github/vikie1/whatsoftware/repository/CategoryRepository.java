package io.github.vikie1.whatsoftware.repository;

import io.github.vikie1.whatsoftware.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    <T> T findAllByCatNameAllIgnoreCase(String catName);
    //List<CategoryEntity> findAllBySoftwareAllIgnoreCase(String software);
    List<CategoryEntity> findAllByNestedCategoryAllIgnoreCase(String nestedCategory);
    //CategoryEntity findBySoftwareAllIgnoreCase(String software);
    CategoryEntity findByNestedCategoryAllIgnoreCase(String nestedCategory);
    //boolean existsBySoftwareAllIgnoreCase(String software);
    boolean existsByNestedCategoryAllIgnoreCase(String nestedCategory);
    boolean existsByCatNameAllIgnoreCase(String catName);
    //void deleteBySoftwareAllIgnoreCase(String software);
}
