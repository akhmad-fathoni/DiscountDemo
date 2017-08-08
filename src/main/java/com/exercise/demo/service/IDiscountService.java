package com.exercise.demo.service;

/**
 * Created by Fathoni on 8/8/2017.
 */
public interface IDiscountService {
    Double getNetPayable(Integer storeId, Integer buyerId, Double totalBill);
}
