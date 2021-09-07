package io.github.vikie1.whatsoftware.repository;

import io.github.vikie1.whatsoftware.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
    TypeEntity findBySoftwareAllIgnoreCase(String software);
    TypeEntity findByTypeAllIgnoreCase(String type);
}
