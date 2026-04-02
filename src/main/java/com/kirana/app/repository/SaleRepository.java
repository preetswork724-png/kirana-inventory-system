package com.kirana.app.repository;

import com.kirana.app.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query("SELECT MAX(s.date) FROM Sale s WHERE s.productId = :productId")
    LocalDateTime findLastSaleDate(@Param("productId") Long productId);

    @Query("SELECT s.productId, SUM(s.quantity) FROM Sale s GROUP BY s.productId ORDER BY SUM(s.quantity) DESC")
    List<Object[]> getTopSellingProducts();

    @Query("SELECT SUM(s.totalPrice) FROM Sale s")
    Double getTotalRevenue();
}