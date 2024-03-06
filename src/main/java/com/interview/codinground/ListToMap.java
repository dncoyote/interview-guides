package com.interview.codinground;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.interview.codinground.model.StudentDetail;

public class ListToMap {

    public static void main (String[] args){

        List<StudentDetail> list = Arrays.asList(new StudentDetail("1", "Aasiya", "A", 99),
        new StudentDetail("2","Bilal","A",55), new StudentDetail("3","Faizan","C",66));

        Map<String,List<StudentDetail>> map = list.stream().collect(Collectors.groupingBy(StudentDetail::getDivision));
        // System.out.println(map);
        map.forEach((keyy, value)->System.out.println(keyy+","+value));

    } 
    
}
