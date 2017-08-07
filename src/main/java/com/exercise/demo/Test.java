package com.exercise.demo;

import com.exercise.demo.utils.Utils;

import java.util.Date;

/**
 * Created by Fathoni on 8/4/2017.
 */
public class Test {
    public static void main(String[] args){
        Date d1 = Utils.parseDate("2001-01-01");
        Date d2 = Utils.parseDate("2011-01-01");

        System.out.println(((d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000))/365);

    }
}
