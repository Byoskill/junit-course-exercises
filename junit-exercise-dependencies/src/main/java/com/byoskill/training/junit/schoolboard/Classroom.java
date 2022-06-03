package com.byoskill.training.junit.schoolboard;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.unmodifiableList;

/**
 * This component holds the annuary of the students from a specific classroom. We do know why but the accesses are quite slow.
 */
public class Classroom {
    private final List<Student> students;
    private AuthenticationService authenticationService;

    public Classroom() {
        students = loadStudents();
    }

    private List<Student> loadStudents() {
        try {
            Thread.sleep(30_0000);
        } catch (InterruptedException e) {
            // Nothing to do
        }
        return DemoStudents.getStudentList();
    }

    /**
     * returns all the students
     *
     * @param userToken
     * @return all the students.
     */
    public List<Student> allStudents(UserToken userToken) throws IllegalAccessException {
        this.authenticationService.controlAccess(userToken);
        return unmodifiableList(students);
    }

    /**
     * Fins a specific student
     *
     * @param surname   the student
     * @param userToken the user token.
     * @return the student.
     */
    public Optional<? extends StudentDetails> findStudent(String surname,
                                                          UserToken userToken) throws IllegalAccessException {
        this.authenticationService.controlAccess(userToken);
        return students.stream()
                       .filter(Student.byName(surname))
                       .findFirst();
    }


    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * This method assigns a mark to a student
     *
     * @param surname   the surname of the student
     * @param mark      the mark
     * @param userToken the token to get access to the functionality.
     * @throws IllegalAccessException
     */
    public void giveMark(String surname, int mark, UserToken userToken) throws IllegalAccessException {
        this.authenticationService.controlAccess(userToken);
        final Optional<Student> studentSearch = students.stream()
                                                        .filter(Student.byName(surname))
                                                        .findFirst();
        if (studentSearch.isEmpty()) {
            System.exit(444); // Crazy bug here
        }
        final Student studentDetails = studentSearch.get();
        studentDetails.setMark(mark);
    }
}
