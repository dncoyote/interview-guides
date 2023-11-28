package com.interview.corejava;

import java.util.Arrays;
import java.util.List;

import com.interview.corejava.model.Person;

public class MethodRefenceDemo {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice"),
                new Person("Bob"),
                new Person("Charlie"));

        // Using lambda expression
        System.out.println("\n" + //
                "Lambda Expression\n");
        people.forEach(person -> person.printDetails());

        // Using method reference
        System.out.println("\n" + //
                "Method Reference\n");
        people.forEach(Person::printDetails);

        // Using traditional approach
        System.out.println("\n" + //
                "Tradition\n");
        for (Person person : people) {
            person.printDetails();
        }
    }
}
