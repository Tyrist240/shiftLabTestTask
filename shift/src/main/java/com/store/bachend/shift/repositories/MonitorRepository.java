package com.store.bachend.shift.repositories;

import com.store.bachend.shift.entities.MonitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepository extends JpaRepository<MonitorEntity, Long> {
}
