/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;
import static java.util.Calendar.DAY_OF_WEEK;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/**
 *
 * @author Alejandro
 */
public class Date {
    public static void main(String[] args) {
        int year = 20;
        LocalDate fecha = LocalDate.of(2017,06,3);
        DayOfWeek day = fecha.getDayOfWeek();
        String dia = day.name();
        System.out.println(dia);
    }
        
    }
