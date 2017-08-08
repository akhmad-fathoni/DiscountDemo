package com.exercise.demo.service;

import com.exercise.demo.entity.Store;

/**
 * Created by Fathoni on 8/8/2017.
 */
public interface IStoreService {
    Store createStore(Integer id, String name, String type);
    long total();
    Iterable<Store> lookup();
}
