package io.github.vikie1.whatsoftware.repository;

import io.github.vikie1.whatsoftware.entity.SoftwareEntity;
import io.github.vikie1.whatsoftware.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoftwareRepository extends JpaRepository<SoftwareEntity, Long> {
    SoftwareEntity findByNameAllIgnoreCase(String name);
    boolean existsByName(String name);
    void deleteByName(String name);
    List<SoftwareEntity> findAllByTypeEntity(TypeEntity type);
}
