package com.exercise.demo.repo;

import com.exercise.demo.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Fathoni on 8/4/2017.
 */
public interface PersonRepository extends CrudRepository<Person, Integer>{
}
