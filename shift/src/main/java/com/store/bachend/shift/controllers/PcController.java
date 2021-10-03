package com.store.bachend.shift.controllers;

import com.store.bachend.shift.entities.PcEntity;
import com.store.bachend.shift.exceptions.NoEntityException;
import com.store.bachend.shift.services.PcService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/store/pc")
@RequiredArgsConstructor
public class PcController {

    @Autowired
    private PcService pcService;

    @PostMapping(value = "/upload")
    public void uploadProduct(@ModelAttribute PcEntity pcEntity) {
        pcService.upload(pcEntity);
    }

    @PatchMapping(value = "/update/{id}")
    public void updateProduct(@ModelAttribute PcEntity pcEntity, @PathVariable String id) throws NoEntityException {
        pcService.update(pcEntity, Long.parseLong(id));
    }

    @GetMapping(value = "/getByType")
    public List<PcEntity> getByType() {
        return pcService.getAll();
    }

}
