package com.exercise.demo.service;

import com.exercise.demo.entity.Store;
import com.exercise.demo.repo.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Fathoni on 8/4/2017.
 */
@Service
public class StoreService {
    private StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    public Store createStore(Integer id, String name, String type){
        return storeRepository.save(new Store(id, name, type));
    }

    public long total(){
        return storeRepository.count();
    }

    public Iterable<Store> lookup(){
        return storeRepository.findAll();
    }
}
