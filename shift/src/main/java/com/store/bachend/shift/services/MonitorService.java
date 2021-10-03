package com.store.bachend.shift.services;

import com.store.bachend.shift.entities.MonitorEntity;
import com.store.bachend.shift.entities.PcEntity;
import com.store.bachend.shift.exceptions.NoEntityException;
import com.store.bachend.shift.repositories.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MonitorService {

    @Autowired
    private MonitorRepository monitorRepository;

    @Transactional
    public void upload(MonitorEntity monitorEntity) {
        monitorRepository.save(monitorEntity);
    }

    @Transactional
    public void update(MonitorEntity monitorEntity, Long id) throws NoEntityException {
        MonitorEntity monitorEntityOld = monitorRepository.findById(id).orElseThrow(() -> new NoEntityException(id));
        monitorEntityOld.setSerialNumber(monitorEntity.getSerialNumber());
        monitorEntityOld.setCreator(monitorEntity.getCreator());
        monitorEntityOld.setPrice(monitorEntity.getPrice());
        monitorEntityOld.setCountInStore(monitorEntity.getCountInStore());
        monitorEntityOld.setDiagonal(monitorEntity.getDiagonal());
    }

    public List<MonitorEntity> getById(Long id) {
        return monitorRepository.findAllById(Collections.singletonList(id));
    }

    public List<MonitorEntity> getAll() {
        return monitorRepository.findAll();
    }

}
