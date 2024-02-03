package com.interview.codinground;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RepeatedValuesInList {

    public static void main(String[] args) {

        List<Integer> listVal = Arrays.asList(1, 2, 4, 1);

        List<Integer> distinctList = listVal.stream().filter(i -> listVal.indexOf(i) == listVal.lastIndexOf(i))
                .distinct().collect(Collectors.toList());

        List<Integer> missingList = listVal.stream().filter(value -> !distinctList.contains(value))
                .collect(Collectors.toList());

        System.out.println(missingList);
    }
}
