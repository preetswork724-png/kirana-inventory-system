package com.kirana.app.service;

import com.kirana.app.model.Product;
import com.kirana.app.model.RevenueResponse;
import com.kirana.app.model.TopSellingProduct;
import com.kirana.app.repository.ProductRepository;
import com.kirana.app.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private SaleRepository saleRepository;

    // ✅ ADD PRODUCT
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    // ✅ GET ALL PRODUCTS
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // ✅ LOW STOCK
    public List<Product> getLowStockProducts() {
        return repository.findByStockQuantityLessThan(10);
    }

    // ✅ DEAD STOCK
    public List<Product> getDeadStockProducts() {

        List<Product> allProducts = repository.findAll();
        List<Product> deadStock = new ArrayList<>();

        for (Product product : allProducts) {

            LocalDateTime lastSaleDate = saleRepository.findLastSaleDate(product.getId());

            if (lastSaleDate == null) {
                deadStock.add(product);
            }
            else if (lastSaleDate.isBefore(LocalDateTime.now().minusDays(15))) {
                deadStock.add(product);
            }
        }

        return deadStock;
    }

    public List<TopSellingProduct> getTopSellingProducts() {

        List<Object[]> results = saleRepository.getTopSellingProducts();
        List<TopSellingProduct> response = new ArrayList<>();

        for (Object[] row : results) {

            Long productId = (Long) row[0];
            Long quantity = (Long) row[1];

            Product product = repository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            response.add(new TopSellingProduct(product.getName(), quantity.intValue()));
        }

        return response;
    }

    public RevenueResponse getTotalRevenue() {
        Double revenue = saleRepository.getTotalRevenue();
        return new RevenueResponse(revenue != null ? revenue : 0.0);
    }
}