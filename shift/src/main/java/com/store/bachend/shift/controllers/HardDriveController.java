package com.store.bachend.shift.controllers;

import com.store.bachend.shift.entities.HardDriveEntity;
import com.store.bachend.shift.exceptions.NoEntityException;
import com.store.bachend.shift.services.HardDriveService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/store/harddrive")
@RequiredArgsConstructor
public class HardDriveController {

    @Autowired
    private HardDriveService hardDriveService;

    @PostMapping(value = "/upload")
    public void uploadProduct(@ModelAttribute HardDriveEntity hardDriveEntity) {
        hardDriveService.upload(hardDriveEntity);
    }

    @PatchMapping(value = "/update/{id}")
    public void updateProduct(@ModelAttribute HardDriveEntity hardDriveEntity, @PathVariable String id) throws NoEntityException {
        hardDriveService.update(hardDriveEntity, Long.parseLong(id));
    }

    @GetMapping(value = "/getByType")
    public List<HardDriveEntity> getByType() {
        return hardDriveService.getAll();
    }

}
