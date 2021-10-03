package com.store.bachend.shift.controllers;

import com.store.bachend.shift.entities.LaptopEntity;
import com.store.bachend.shift.exceptions.NoEntityException;
import com.store.bachend.shift.services.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/store/laptop")
@RequiredArgsConstructor
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping(value = "/upload")
    public void uploadProduct(@ModelAttribute LaptopEntity laptopEntity) {
        laptopService.upload(laptopEntity);
    }

    @PatchMapping(value = "/update/{id}")
    public void updateProduct(@ModelAttribute LaptopEntity laptopEntity, @PathVariable String id) throws NoEntityException {
        laptopService.update(laptopEntity, Long.parseLong(id));
    }

    @GetMapping(value = "/getByType")
    public List<LaptopEntity> getByType() {
        return laptopService.getAll();
    }

}
