package com.kirana.app.controller;

import com.kirana.app.model.Purchase;
import com.kirana.app.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @PostMapping
    public Purchase addPurchase(@RequestParam Long productId,
                                @RequestParam int quantity,
                                @RequestParam double costPrice) {
        return service.addPurchase(productId, quantity, costPrice);
    }
}