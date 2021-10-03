package com.store.bachend.shift.controllers;

import com.store.bachend.shift.entities.MonitorEntity;
import com.store.bachend.shift.exceptions.NoEntityException;
import com.store.bachend.shift.services.MonitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/store/monitor")
@RequiredArgsConstructor
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @PostMapping(value = "/upload")
    public void uploadProduct(@ModelAttribute MonitorEntity monitorEntity) {
        monitorService.upload(monitorEntity);
    }

    @PatchMapping(value = "/update/{id}")
    public void updateProduct(@ModelAttribute MonitorEntity monitorEntity, @PathVariable String id) throws NoEntityException {
        monitorService.update(monitorEntity, Long.parseLong(id));
    }

    @GetMapping(value = "/getByType")
    public List<MonitorEntity> getByType() {
        return monitorService.getAll();
    }

}
