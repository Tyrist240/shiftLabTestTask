package com.store.bachend.shift.services;


import com.store.bachend.shift.entities.AbstractEntity;
import com.store.bachend.shift.exceptions.NoEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StoreService {

    @Autowired
    private PcService pcService;

    @Autowired
    private MonitorService monitorService;

    @Autowired
    private LaptopService laptopService;

    @Autowired
    private HardDriveService hardDriveService;

    public AbstractEntity getById(Long id) throws NoEntityException {
        Stream<AbstractEntity> streamOfFound = Stream.<AbstractEntity>builder().build();

        streamOfFound = Stream.concat(streamOfFound, pcService.getById(id).stream());
        streamOfFound = Stream.concat(streamOfFound, monitorService.getById(id).stream());
        streamOfFound = Stream.concat(streamOfFound, hardDriveService.getById(id).stream());
        streamOfFound = Stream.concat(streamOfFound, laptopService.getById(id).stream());

        List<AbstractEntity> listOfFound = streamOfFound.collect(Collectors.toList());

        if (listOfFound.isEmpty()) {
            throw new NoEntityException(id);
            //return null;
        }
        return listOfFound.get(0);
    }

}
