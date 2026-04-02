package com.kirana.app.model;

import lombok.Data;

@Data
public class RevenueResponse {
    private Double totalRevenue;

    public RevenueResponse(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}