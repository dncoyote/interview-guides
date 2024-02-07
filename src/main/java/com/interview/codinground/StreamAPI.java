package com.interview.codinground;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamAPI {

    class StudentDetail {
        private Integer rollno;
        private String name;
        private Integer mark;

        public StudentDetail(Integer rollno, String name, Integer mark) {
            this.rollno = rollno;
            this.name = name;
            this.mark = mark;
        }

        public Integer getRollno() {
            return rollno;
        }

        public void setRollno(Integer rollno) {
            this.rollno = rollno;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getMark() {
            return mark;
        }

        public void setMark(Integer mark) {
            this.mark = mark;
        }

    }

    public static void main(String[] args) {
        /**
         * List of students with firstname,roll number and marks
         * 
         * Get the studentList from database, calculate the sum using java 8
         * functionalities and streams
         * Get the studentList from database and find the count
         * 
         */
        StreamAPI streamAPI = new StreamAPI();

        List<StudentDetail> studentList = Arrays.asList(streamAPI.new StudentDetail(1, "Alex", 10),
                streamAPI.new StudentDetail(2, "Basil", 10),
                streamAPI.new StudentDetail(3, "Carl", 10),
                streamAPI.new StudentDetail(4, "John", 10));

        int sum = studentList.stream().mapToInt(StudentDetail::getMark).sum();

        System.out.println("Sum of the marks of student:" + sum);

        long count = studentList.stream().count();

        System.out.println("Sum of the marks of student:" + count);

        Optional<StudentDetail> detail = studentList.stream().filter(student -> student.getRollno() == 2).findFirst();

        System.out.println(detail);
    }
}
