package com.interview.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.interview.corejava.model.Person;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jabbar", 1));
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Sorting using a Comparator
        // Collections.sort(people, new AgeComparator());

        people.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("Age");
        people.forEach(person -> System.out.println(person.getName() + " - " + person.getAge()));
        people.sort(Comparator.comparing(Person::getName));
        System.out.println("Name");
        // Displaying sorted list
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}

// Custom Comparator for sorting by age
class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return Integer.compare(person1.getAge(), person2.getAge());
    }
}
