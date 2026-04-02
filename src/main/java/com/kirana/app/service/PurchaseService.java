package com.kirana.app.service;

import com.kirana.app.model.Product;
import com.kirana.app.model.Purchase;
import com.kirana.app.repository.ProductRepository;
import com.kirana.app.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    public Purchase addPurchase(Long productId, int quantity, double costPrice) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Increase stock
        product.setStockQuantity(product.getStockQuantity() + quantity);
        productRepository.save(product);

        Purchase purchase = new Purchase();
        purchase.setProductId(productId);
        purchase.setQuantity(quantity);
        purchase.setCostPrice(costPrice);
        purchase.setDate(LocalDateTime.now());

        return purchaseRepository.save(purchase);
    }
}