package com.exercise.demo.service;

import com.exercise.demo.entity.Person;
import com.exercise.demo.entity.Store;
import com.exercise.demo.repo.PersonRepository;
import com.exercise.demo.repo.StoreRepository;
import com.exercise.demo.service.impl.DiscountService;
import com.exercise.demo.utils.Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Created by Fathoni on 8/7/2017.
 */

public class DiscountServiceTest {

    private static Integer buyerCustomer = 1;
    private static Integer buyerAffiliate = 2;
    private static Integer buyerEmployee = 3;

    private static Integer marchantStore = 1;
    private static Integer marchantGrocery = 4;

    @Mock
    private Store store;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private StoreRepository storeRepository;

    @InjectMocks
    private DiscountService discountService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Held store type is Store
     * Buyer type is Customer more than 3 years (got 10% from bill) (get disc $20)
     * Total bill is more than limit ($200 - get non percentage disc) (get disc $10)
     */
    @Test
    public void getPayableCustomer01Test(){
        Store st1 = new Store();
        st1.setType(Store.ST);

        Person ps1 = new Person();
        ps1.setType(Person.CUS);
        ps1.setJoinDate(Utils.parseDate("2011-05-12"));

        when(storeRepository.findOne(anyInt())).thenReturn(st1);
        when(personRepository.findOne(anyInt())).thenReturn(ps1);

        Double payableAmount = discountService.getNetPayable(marchantStore,buyerCustomer,200.0);
        Assert.assertEquals(170.0, payableAmount, 0);
    }

    /**
     * Held store type is Grocer
     * Buyer type is Customer more than 3 years (no percentage disc)
     * Total bill is more than limit ($200 - get non percentage disc) (get disc $10)
     */
    @Test
    public void getPayableCustomer02Test(){
        Store st1 = new Store();
        st1.setType(Store.GR);

        Person ps1 = new Person();
        ps1.setType(Person.CUS);
        ps1.setJoinDate(Utils.parseDate("2011-05-12"));

        when(storeRepository.findOne(anyInt())).thenReturn(st1);
        when(personRepository.findOne(anyInt())).thenReturn(ps1);

        Double payableAmount = discountService.getNetPayable(marchantGrocery,buyerCustomer,200.0);
        Assert.assertEquals(190.0, payableAmount, 0);
    }
    /**
     * Held store type is Store
     * Buyer type is Customer more than 3 years (got 10% from bill) (get disc $6)
     * Total bill is less than limit ($60 - do not get non percentage disc)
     */
    @Test
    public void getPayableCustomer03Test(){
        Store st1 = new Store();
        st1.setType(Store.ST);

        Person ps1 = new Person();
        ps1.setType(Person.CUS);
        ps1.setJoinDate(Utils.parseDate("2011-05-12"));

        when(storeRepository.findOne(anyInt())).thenReturn(st1);
        when(personRepository.findOne(anyInt())).thenReturn(ps1);

        Double payableAmount = discountService.getNetPayable(marchantStore,buyerCustomer,60.0);
        Assert.assertEquals(54.0, payableAmount, 0);
    }

    /**
     * Held store type is Grocer
     * Buyer type is Customer more than 3 years (no percentage disc for Grocer)
     * Total bill is less than limit (do not get non percentage disc)
     */
    @Test
    public void getPayableCustomer04Test(){
        Store st1 = new Store();
        st1.setType(Store.GR);

        Person ps1 = new Person();
        ps1.setType(Person.CUS);
        ps1.setJoinDate(Utils.parseDate("2011-05-12"));

        when(storeRepository.findOne(anyInt())).thenReturn(st1);
        when(personRepository.findOne(anyInt())).thenReturn(ps1);

        Double payableAmount = discountService.getNetPayable(marchantGrocery,buyerCustomer,60.0);
        Assert.assertEquals(60.0, payableAmount, 0);
    }

    /**
     * Held store type is Store
     * Buyer type is Affiliate more than 3 years (get percentage disc 15%) (get $30)
     * Total bill is more than limit ($200 - get non percentage disc) (get $10)
     */
    @Test
    public void getPayableCustomer05Test(){
        Store st1 = new Store();
        st1.setType(Store.ST);

        Person ps1 = new Person();
        ps1.setType(Person.AFF);
        ps1.setJoinDate(Utils.parseDate("2011-05-12"));

        when(storeRepository.findOne(anyInt())).thenReturn(st1);
        when(personRepository.findOne(anyInt())).thenReturn(ps1);

        Double payableAmount = discountService.getNetPayable(marchantStore,buyerCustomer,200.0);
        Assert.assertEquals(160.0, payableAmount, 0);
    }

    /**
     * Held store type is Grocer
     * Buyer type is Affiliate more than 3 years (no percentage discount)
     * Total bill is less than limit ($70 - do not get non percentage disc)
     */
    @Test
    public void getPayableCustomer06Test(){
        Store st1 = new Store();
        st1.setType(Store.GR);

        Person ps1 = new Person();
        ps1.setType(Person.AFF);
        ps1.setJoinDate(Utils.parseDate("2011-05-12"));

        when(storeRepository.findOne(anyInt())).thenReturn(st1);
        when(personRepository.findOne(anyInt())).thenReturn(ps1);

        Double payableAmount = discountService.getNetPayable(marchantGrocery,buyerCustomer,70.0);
        Assert.assertEquals(70.0, payableAmount, 0);
    }

    /**
     * Held store type is Store
     * Buyer type is Employee more than 3 years (get 20 % from bill) (get $40)
     * Total bill is more than limit (get non percentage disc) (get $10)
     */
    @Test
    public void getPayableCustomer07Test(){
        Store st1 = new Store();
        st1.setType(Store.ST);

        Person ps1 = new Person();
        ps1.setType(Person.EMP);
        ps1.setJoinDate(Utils.parseDate("2011-05-12"));

        when(storeRepository.findOne(anyInt())).thenReturn(st1);
        when(personRepository.findOne(anyInt())).thenReturn(ps1);

        Double payableAmount = discountService.getNetPayable(marchantStore,buyerCustomer,200.0);
        Assert.assertEquals(150.0, payableAmount, 0);
    }

    /**
     * Held store type is Grocer
     * Buyer type is Employee more than 3 years (no percentage discount for Grocery)
     * Total bill is less than limit (do not get non percentage disc)
     */
    @Test
    public void getPayableCustomer08Test(){
        Store st1 = new Store();
        st1.setType(Store.GR);

        Person ps1 = new Person();
        ps1.setType(Person.EMP);
        ps1.setJoinDate(Utils.parseDate("2011-05-12"));

        when(storeRepository.findOne(anyInt())).thenReturn(st1);
        when(personRepository.findOne(anyInt())).thenReturn(ps1);

        Double payableAmount = discountService.getNetPayable(marchantGrocery,buyerCustomer,90.0);
        Assert.assertEquals(90.0, payableAmount, 0);
    }

    /**
     * Held store type is Store
     * Buyer type is Customer less than 3 years (no percentage disc)
     * Total bill is more than limit ($200 - get non percentage disc) (get disc $10)
     */
    @Test
    public void getPayableCustomer10Test(){
        Store st1 = new Store();
        st1.setType(Store.ST);

        Person ps1 = new Person();
        ps1.setType(Person.CUS);
        ps1.setJoinDate(Utils.parseDate("2016-05-12"));

        when(storeRepository.findOne(anyInt())).thenReturn(st1);
        when(personRepository.findOne(anyInt())).thenReturn(ps1);

        Double payableAmount = discountService.getNetPayable(marchantStore,buyerCustomer,200.0);
        Assert.assertEquals(190.0, payableAmount, 0);
    }

    /**
     * Held store type is Store
     * Buyer type is Customer less than 3 years (no percentage disc)
     * Total bill is less than limit ($99 - do not get non percentage disc)
     */
    @Test
    public void getPayableCustomer11Test(){
        Store st1 = new Store();
        st1.setType(Store.ST);

        Person ps1 = new Person();
        ps1.setType(Person.CUS);
        ps1.setJoinDate(Utils.parseDate("2016-05-12"));

        when(storeRepository.findOne(anyInt())).thenReturn(st1);
        when(personRepository.findOne(anyInt())).thenReturn(ps1);

        Double payableAmount = discountService.getNetPayable(marchantStore,buyerCustomer,99.0);
        Assert.assertEquals(99.0, payableAmount, 0);
    }

}
