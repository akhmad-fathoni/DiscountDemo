package com.exercise.demo.controller;

import com.exercise.demo.entity.Store;
import com.exercise.demo.repo.StoreRepository;
import com.exercise.demo.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

/**
 * Created by Fathoni on 8/7/2017.
 */
@RestController
@RequestMapping(path = "/discounts/{storeId}/payable")
public class DiscountController {
    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private IDiscountService discountService;

    @RequestMapping(method = RequestMethod.POST)
    public Double getDiscountByStoreType(@PathVariable(value = "storeId") Integer storeId, @RequestBody PayableDto payableDto){
        verifyStore(storeId);
        return discountService.getNetPayable(storeId, payableDto.getBuyerId(), payableDto.getTotalBill());
    }

    private Store verifyStore(Integer storeId) throws NoSuchElementException{
        Store s = storeRepository.findOne(storeId);
        if (s == null){
            throw new NoSuchElementException("Store " + storeId + " not found!");
        }
        return s;
    }
}
