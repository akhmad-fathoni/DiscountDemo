package com.exercise.demo.controller;

/**
 * Created by nabila.azam on 8/7/2017.
 */
public class PayableDto {
    private Integer buyerId;
    private Double totalBill;
    public PayableDto(){

    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }
}
