package com.kirana.app.service;

import com.kirana.app.model.Product;
import com.kirana.app.model.Sale;
import com.kirana.app.repository.ProductRepository;
import com.kirana.app.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    public Sale makeSale(Long productId, int quantity) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStockQuantity() < quantity) {
            throw new RuntimeException("Not enough stock");
        }

        // Reduce stock
        product.setStockQuantity(product.getStockQuantity() - quantity);
        productRepository.save(product);

        // Create sale record
        Sale sale = new Sale();
        sale.setProductId(productId);
        sale.setQuantity(quantity);
        sale.setTotalPrice(product.getSellingPrice() * quantity);
        sale.setDate(LocalDateTime.now());

        return saleRepository.save(sale);
    }
}