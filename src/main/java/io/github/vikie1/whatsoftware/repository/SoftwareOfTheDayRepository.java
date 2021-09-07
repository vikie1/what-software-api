package io.github.vikie1.whatsoftware.repository;

import io.github.vikie1.whatsoftware.entity.SoftwareOfTheDayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareOfTheDayRepository extends JpaRepository<SoftwareOfTheDayEntity, Long> {
    SoftwareOfTheDayEntity findBySoftwareAllIgnoreCase(String software);
    SoftwareOfTheDayEntity findByDateAllIgnoreCase(String date);
    boolean existsBySoftwareAllIgnoreCase(String software);
    boolean existsByDateAllIgnoreCase(String date);
    void deleteByDateAllIgnoreCase(String date);
    void deleteBySoftwareAllIgnoreCase(String software);
}
