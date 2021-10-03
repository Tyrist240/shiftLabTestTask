package com.store.bachend.shift.repositories;

import com.store.bachend.shift.entities.PcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcRepository extends JpaRepository<PcEntity, Long> {
}
