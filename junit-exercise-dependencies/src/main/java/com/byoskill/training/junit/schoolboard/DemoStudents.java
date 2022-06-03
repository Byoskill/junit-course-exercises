package com.byoskill.training.junit.schoolboard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoStudents {

    private static final String[] defaultSurnames = {
            "Smith",
            "Johnson",
            "Williams",
            "Brown",
            "Jones",
            "Garcia",
            "Miller",
            "Davis",
            "Rodriguez",
            "Martinez",
            "Hernandez",
            "Lopez",
            "Gonzales",
            "Wilson",
            "Anderson",
            "Thomas",
            "Taylor",
            "Moore",
            "Jackson"};

    public static List<Student> getStudentList() {
        return Arrays.stream(defaultSurnames)
                     .map(Student::new)
                     .collect(Collectors.toList());
    }
}
