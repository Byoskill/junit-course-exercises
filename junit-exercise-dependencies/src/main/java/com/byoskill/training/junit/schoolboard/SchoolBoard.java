package com.byoskill.training.junit.schoolboard;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * This is the main class of the application.
 */
public class SchoolBoard {
    private final AuthenticationService authenticationService = new AuthenticationService();
    private final Classroom classroom;

    public SchoolBoard() {
        classroom = new Classroom();
        classroom.setAuthenticationService(authenticationService);
    }

    /**
     * Computes the average mark for the class.
     *
     * @return the average or empty if no students are presents in
     */
    public OptionalDouble computeClassAverageScore(UserToken userToken) throws IllegalAccessException {
        this.authenticationService.controlAccess(userToken);
        final List<Student> students = this.classroom.allStudents(userToken);
        return students.stream()
                       .mapToDouble(Student::getMark)
                       .average();
    }

    /**
     * Sets a mark for a student
     *
     * @param surname   the surname
     * @param mark      the mark
     * @param userToken the token for the authentication
     */
    public void setMark(String surname, int mark, UserToken userToken) throws IllegalAccessException {
        this.authenticationService.controlAccess(userToken);
        final Optional<? extends StudentDetails> student = this.classroom.findStudent(surname, userToken);
        if (student.isPresent()) {
            this.classroom.giveMark(surname, mark, userToken);
        } else {
            throw new IllegalAccessException("Invalid surname provided");
        }
    }

}
