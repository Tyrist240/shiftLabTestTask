package com.store.bachend.shift.repositories;

import com.store.bachend.shift.entities.HardDriveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDriveRepository extends JpaRepository<HardDriveEntity, Long> {
}
