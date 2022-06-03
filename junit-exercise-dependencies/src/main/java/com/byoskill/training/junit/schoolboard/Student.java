package com.byoskill.training.junit.schoolboard;

import java.util.Objects;
import java.util.function.Predicate;

public class Student implements StudentDetails {
    private final String surname;
    private Integer mark = null;

    public Student(String surname) {
        this.surname = surname;
    }

    public static Predicate<? super Student> byName(String surname) {
        return student -> student.hasSurname(surname);
    }

    private boolean hasSurname(String surname) {
        return Objects.equals(this.surname, surname);
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        if (mark < 0 || mark > 20) throw new IllegalArgumentException("Mark is invalid");
        this.mark = mark;
    }

    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("surname='").append(surname).append('\'');
        sb.append(", mark=").append(mark);
        sb.append('}');
        return sb.toString();
    }
}
