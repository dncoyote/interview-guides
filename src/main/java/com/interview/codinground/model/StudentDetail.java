package com.interview.codinground.model;

public class StudentDetail {
    private String rollno;
    private String name;
    private String division;
    private Integer mark;

    public StudentDetail(String rollno, String name, String division, Integer mark) {
        this.rollno = rollno;
        this.name = name;
        this.division = division;
        this.mark = mark;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
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

    @Override
    public String toString() {
        return "Student{" +
                "rollno='" + rollno + '\'' +
                ", name='" + name + '\'' +
                ", division='" + division + '\'' +
                '}';
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
