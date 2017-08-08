package com.exercise.demo.service;

import com.exercise.demo.entity.Person;

import java.util.Date;

/**
 * Created by Fathoni on 8/8/2017.
 */
public interface IPersonService {
    Person createPerson(Integer id, String name, Date joinDate, String type, Integer storeId);
    long total();
    Iterable<Person> lookup();
}
