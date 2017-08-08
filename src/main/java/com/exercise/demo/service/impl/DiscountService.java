package com.exercise.demo.service.impl;

import com.exercise.demo.entity.Person;
import com.exercise.demo.entity.Store;
import com.exercise.demo.repo.PersonRepository;
import com.exercise.demo.repo.StoreRepository;
import com.exercise.demo.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Fathoni on 8/4/2017.
 */
@Service
public class DiscountService implements IDiscountService{
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private StoreRepository storeRepository;

    private static final Double discMargin = 100.0;
    private static final Double constNonPercentageDisc = 5.0;

    public Double getNetPayable(Integer storeId, Integer buyerId, Double totalBill){
        Store store = storeRepository.findOne(storeId);

        if (store == null){
            return 0.0;
        }

        Double afterDisc = totalBill.doubleValue();

        int discMultiply = (int) (totalBill/discMargin);
        if (discMultiply > 0){
            Double nonPercentageDiscAmount = discMultiply * constNonPercentageDisc;
            afterDisc = afterDisc - nonPercentageDiscAmount;
        }

        /**
         * Checking whether the store is Grocery,
         * if it is on Grocery then the net payable is the total bill (no more discount)
         */
        if (store.getType() == Store.GR){
            return afterDisc;
        }

        /**
         * Checking the buyer type
         */

        Person person = personRepository.findOne(buyerId);

        if (person==null){
            return 0.0;
        }

        if (person.getType() == Person.EMP){
            return afterDisc - (totalBill * 20/100);
        }
        if (person.getType() == Person.AFF){
            return afterDisc - (totalBill * 15/100);
        }
        if (person.getType() == Person.CUS){
            Date currentDate = new Date();
            int diff = (int)((currentDate.getTime() - person.getJoinDate().getTime())/(24 * 60 * 60 * 1000))/365;
            /** if it more than 3 (year) **/
            if (diff > 3){
                return afterDisc - (totalBill * 10/100);
            }
        }

        return afterDisc;
    }
}
