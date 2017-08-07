package com.exercise.demo.service;

import com.exercise.demo.entity.Person;
import com.exercise.demo.entity.Store;
import com.exercise.demo.repo.PersonRepository;
import com.exercise.demo.repo.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Fathoni on 8/4/2017.
 */
@Service
public class PersonService {
    private PersonRepository personRepository;
    private StoreRepository storeRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, StoreRepository storeRepository){
        this.personRepository = personRepository;
        this.storeRepository = storeRepository;
    }

    public Person createPerson(Integer id, String name, Date joinDate, String type, Integer storeId){
        Store store = storeRepository.findOne(storeId);
        if (store != null)
            return personRepository.save(new Person(id, name, joinDate, type, store));
        else{
            return null;
        }
    }

    public Iterable<Person> lookup() {
        return personRepository.findAll();
    }

    public long total(){
        return personRepository.count();
    }
}
