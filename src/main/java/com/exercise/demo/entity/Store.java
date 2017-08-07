package com.exercise.demo.entity;

import javax.persistence.*;

/**
 * Created by Fathoni on 8/4/2017.
 */
@Entity
@Table(name = "store")
public class Store {

    public static final String ST = "Store";
    public static final String GR = "Grocery";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column
    private String name;
    @Column
    private String type;

    public Store(Integer id, String name, String type) {
        this.Id = id;
        this.name = name;
        this.type = type;
    }

    public Store(){}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + Id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
