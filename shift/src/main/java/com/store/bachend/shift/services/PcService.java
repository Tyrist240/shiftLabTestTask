package com.store.bachend.shift.services;

import com.store.bachend.shift.entities.PcEntity;
import com.store.bachend.shift.exceptions.NoEntityException;
import com.store.bachend.shift.repositories.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

@Service
public class PcService {
    @Autowired
    private PcRepository pcRepository;

    public boolean checkArg (PcEntity pcEntity) {

        if (pcEntity.getFormFactor() == null) {
            return true;
        }
        return  pcEntity.getFormFactor().equals("NETTOP")
                                    ||
                pcEntity.getFormFactor().equals("DESKTOP")
                                    ||
                pcEntity.getFormFactor().equals("MONOBLOCK");

    }

    @Transactional
    public void upload(PcEntity pcEntity) {
        if (checkArg(pcEntity)) {
            pcRepository.save(pcEntity);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Transactional
    public void update(PcEntity pcEntity, Long id) throws NoEntityException {
        if (checkArg(pcEntity)) {
            PcEntity pcEntityOld = pcRepository.findById(id).orElseThrow(() -> new NoEntityException(id));
            pcEntityOld.setSerialNumber(pcEntity.getSerialNumber());
            pcEntityOld.setCreator(pcEntity.getCreator());
            pcEntityOld.setPrice(pcEntity.getPrice());
            pcEntityOld.setCountInStore(pcEntity.getCountInStore());
            pcEntityOld.setFormFactor(pcEntity.getFormFactor());
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<PcEntity> getById(Long id) {
        return pcRepository.findAllById(Collections.singletonList(id));
    }

    public List<PcEntity> getAll() {
        return pcRepository.findAll();
    }

}
