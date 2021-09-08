package io.github.vikie1.whatsoftware.repository;

import io.github.vikie1.whatsoftware.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
    TypeEntity findBySoftwareAllIgnoreCase(String software);
    List<TypeEntity> findAllByTypeAllIgnoreCase(String type);
    void deleteBySoftwareAllIgnoreCase(String software);
    boolean existsBySoftwareAllIgnoreCase(String software);
}
