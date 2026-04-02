package com.kirana.app.model;

import lombok.Data;

@Data
public class TopSellingProduct {

    private String productName;
    private int quantitySold;

    public TopSellingProduct(String productName, int quantitySold) {
        this.productName = productName;
        this.quantitySold = quantitySold;
    }
}