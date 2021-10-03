package com.store.bachend.shift.services;

import com.store.bachend.shift.entities.LaptopEntity;
import com.store.bachend.shift.entities.PcEntity;
import com.store.bachend.shift.exceptions.NoEntityException;
import com.store.bachend.shift.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    public boolean checkArg (LaptopEntity laptopEntity) {

        if (laptopEntity.getLaptopDiagonalType() == null) {
            return true;
        }

        return  laptopEntity.getLaptopDiagonalType().equals("THIRTEEN")
                                        ||
                laptopEntity.getLaptopDiagonalType().equals("FOURTEEN")
                                        ||
                laptopEntity.getLaptopDiagonalType().equals("FIFTEEN")
                                        ||
                laptopEntity.getLaptopDiagonalType().equals("SEVENTEEN");

    }

    @Transactional
    public void upload(LaptopEntity laptopEntity) {
        if (checkArg(laptopEntity)) {
            laptopRepository.save(laptopEntity);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Transactional
    public void update(LaptopEntity laptopEntity, Long id) throws NoEntityException {
        if (checkArg(laptopEntity)) {
            LaptopEntity laptopEntityOld = laptopRepository.findById(id).orElseThrow(() -> new NoEntityException(id));
            laptopEntityOld.setSerialNumber(laptopEntity.getSerialNumber());
            laptopEntityOld.setCreator(laptopEntity.getCreator());
            laptopEntityOld.setPrice(laptopEntity.getPrice());
            laptopEntityOld.setCountInStore(laptopEntity.getCountInStore());
            laptopEntityOld.setLaptopDiagonalType(laptopEntity.getLaptopDiagonalType());
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<LaptopEntity> getById(Long id) {
        return laptopRepository.findAllById(Collections.singletonList(id));
    }

    public List<LaptopEntity> getAll() {
        return laptopRepository.findAll();
    }

}
