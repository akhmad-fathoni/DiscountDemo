package com.exercise.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Fathoni on 8/4/2017.
 */
@Entity
@Table(name = "person")
public class Person {

    public static final String EMP = "Employee";
    public static final String AFF = "Affiliate";
    public static final String CUS = "Customer";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column
    private String name;
    @Column
    private Date joinDate;
    @Column
    private String type;
    @ManyToOne
    private Store store;

    public Person(Integer id, String name, Date joinDate, String type, Store store) {
        this.Id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.type = type;
        this.store = store;
    }

    public Person(){}

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + Id +
                ", name='" + name + '\'' +
                ", joinDate=" + joinDate +
                ", type='" + type + '\'' +
                ", store=" + store +
                '}';
    }

}
