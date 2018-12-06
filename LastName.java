package com.iopo;

import java.util.Comparator;

public class LastName implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        try {
            inputIsEmpty(s1, s2);

            return s1.getLastName().compareTo(s2.getLastName());
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    private void inputIsEmpty (Student s1, Student s2) throws ValidationException {

        if ((s1.getFirstName() == "" || s1.getLastName() == "") || (s2.getFirstName() == "" || s2.getLastName() == "")) {
            throw new ValidationException("One of your input is empty!");
        }
    }
}
