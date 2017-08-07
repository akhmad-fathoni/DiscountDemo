package com.exercise.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Fathoni on 8/4/2017.
 */
public class Utils {
    public static Date parseDate(String date){
        try {
            return new SimpleDateFormat("yyyy-mm-dd").parse(date);
        }catch(ParseException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
