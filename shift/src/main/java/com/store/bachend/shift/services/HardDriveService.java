package com.store.bachend.shift.services;

import com.store.bachend.shift.entities.HardDriveEntity;
import com.store.bachend.shift.entities.PcEntity;
import com.store.bachend.shift.exceptions.NoEntityException;
import com.store.bachend.shift.repositories.HardDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class HardDriveService {

    @Autowired
    private HardDriveRepository hardDriveRepository;

    @Transactional
    public void upload(HardDriveEntity hardDriveEntity) {
        hardDriveRepository.save(hardDriveEntity);
    }

    @Transactional
    public void update(HardDriveEntity hardDriveEntity, Long id) throws NoEntityException {
        HardDriveEntity hardDriveEntityOld = hardDriveRepository.findById(id).orElseThrow(() -> new NoEntityException(id));
        hardDriveEntityOld.setSerialNumber(hardDriveEntity.getSerialNumber());
        hardDriveEntityOld.setCreator(hardDriveEntity.getCreator());
        hardDriveEntityOld.setPrice(hardDriveEntity.getPrice());
        hardDriveEntityOld.setCountInStore(hardDriveEntity.getCountInStore());
        hardDriveEntityOld.setCapacity(hardDriveEntity.getCapacity());
    }

    public List<HardDriveEntity> getById(Long id) {
        return hardDriveRepository.findAllById(Collections.singletonList(id));
    }

    public List<HardDriveEntity> getAll() {
        return hardDriveRepository.findAll();
    }

}
