package com.store.bachend.shift.controllers;

import com.store.bachend.shift.entities.AbstractEntity;
import com.store.bachend.shift.exceptions.NoEntityException;
import com.store.bachend.shift.services.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/store")
@RequiredArgsConstructor
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping(value = "/getById/{id}")
    public AbstractEntity getById(@PathVariable String id) throws NoEntityException {
        return storeService.getById(Long.parseLong(id));
    }

}