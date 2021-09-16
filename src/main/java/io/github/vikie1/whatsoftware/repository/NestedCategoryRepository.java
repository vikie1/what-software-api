package io.github.vikie1.whatsoftware.repository;

import io.github.vikie1.whatsoftware.entity.NestedCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NestedCategoryRepository extends JpaRepository<NestedCategoryEntity, Long> {
    <T> T findAllByCatNameAllIgnoreCase(String catName);
    NestedCategoryEntity findBySoftwareAllIgnoreCase(String software);
    List<NestedCategoryEntity> findAllByParentCategoryAllIgnoreCase(String parentCategory);
    <T> T findByCatNameAllIgnoreCaseAndSoftware(String catName, String software, Class<T> type);
    boolean existsBySoftwareAllIgnoreCase(String software);
    boolean existsByCatNameAllIgnoreCase(String catName);
    void deleteBySoftwareAllIgnoreCase(String software);
}
