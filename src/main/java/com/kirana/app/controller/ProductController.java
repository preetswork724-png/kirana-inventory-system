package com.kirana.app.controller;

import com.kirana.app.model.Product;
import com.kirana.app.model.RevenueResponse;
import com.kirana.app.model.TopSellingProduct;
import com.kirana.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/low-stock")
    public List<Product> getLowStockProducts() {
        return service.getLowStockProducts();
    }

    @GetMapping("/dead-stock")
    public List<Product> getDeadStock() {
        return service.getDeadStockProducts();
    }

    @GetMapping("/top-selling")
    public List<TopSellingProduct> topSelling() {
        return service.getTopSellingProducts();
    }

    @GetMapping("/revenue")
    public RevenueResponse getRevenue() {
        return service.getTotalRevenue();
    }
}