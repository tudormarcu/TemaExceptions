package com.iopo;

import java.util.Comparator;

public class DateOfBirth implements Comparator<Student> {

    @Override
    public int compare(Student d1, Student d2) {

        try {
            inputIsEmpty(d1, d2);

            int date1 = Integer.parseInt(d1.getDateOfBirth());
            int date2 = Integer.parseInt(d2.getDateOfBirth());

            int difference = date2 - date1;

            if (difference > 0) {
                return 1;
            } else {
                return -1;
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    private void inputIsEmpty (Student d1, Student d2) throws ValidationException {

        if ((d1.getDateOfBirth() == "" || d2.getDateOfBirth() == "")) {
            throw new ValidationException("One of your input vales is empty!");
        }
    }
}