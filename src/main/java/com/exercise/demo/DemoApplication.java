package com.exercise.demo;

import com.exercise.demo.entity.Person;
import com.exercise.demo.entity.Store;
import com.exercise.demo.service.IPersonService;
import com.exercise.demo.service.IStoreService;
import com.exercise.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private IStoreService storeService;

	@Autowired
	private IPersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		/** Add initial data for Store **/
		storeService.createStore(1, "Store 1", Store.ST);
		storeService.createStore(2, "Store 2", Store.ST);
		storeService.createStore(3, "Store 3", Store.ST);
		storeService.createStore(4, "Grocery 1", Store.GR);
		storeService.createStore(5, "Grocery 2", Store.GR);
		storeService.createStore(6, "Grocery 3", Store.GR);

		storeService.lookup().forEach(store -> System.out.println(store));

		/** Add initial data for Person **/
		personService.createPerson(1, "Customer 1", Utils.parseDate("2011-05-12"), Person.CUS,1);
		personService.createPerson(2, "Affiliate 2", Utils.parseDate("2011-05-12"), Person.AFF,2);
		personService.createPerson(3, "Employee 3", Utils.parseDate("2011-05-12"), Person.EMP,4);

		personService.lookup().forEach(person -> System.out.println(person));

	}
}
