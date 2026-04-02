package com.kirana.app.controller;

import com.kirana.app.model.Sale;
import com.kirana.app.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @PostMapping
    public Sale makeSale(@RequestParam Long productId,
                         @RequestParam int quantity) {
        return service.makeSale(productId, quantity);
    }
}