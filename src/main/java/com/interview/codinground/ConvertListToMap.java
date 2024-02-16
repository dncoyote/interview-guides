package com.interview.codinground;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.interview.codinground.model.StudentDetail;

public class ConvertListToMap {

    public static void main(String[] args) {

        List<StudentDetail> student = new ArrayList<>();
        student.add(new StudentDetail("001", "John", "A", 10));
        student.add(new StudentDetail("002", "Alice", "A", 67));
        student.add(new StudentDetail("003", "Bob", "B", 46));
        // Convert list to map with roll no as key and student object as value
        Map<String, StudentDetail> studentMap = student.stream()
                .collect(Collectors.toMap(StudentDetail::getRollno, st -> st));

        studentMap.forEach((key, value) -> System.out.println(key + ", " + value));

        // Convert list to map with Division as key and list pf student object as value
        Map<String, List<StudentDetail>> studentDivisionMap = student.stream()
                .collect(Collectors.groupingBy(StudentDetail::getDivision));

        studentDivisionMap.forEach((key, value) -> System.out.println(key + ", " + value));
    }

}
