package com.iopo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;


public class StudentRepository {

    private static final String REGEX_AGE = "^(.*)(\\D)(.*)";
    private static final Integer INVALID_DATE = 19000101;
    private static final int CALCULATE_AGE = 10000;

    private static String currentDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
    private final List<Student> myStudentList;

    public StudentRepository() {
        this.myStudentList = new ArrayList<Student>();
    }

    public boolean addStudent(Student student) {

        try {
            addStudentValidation(student.getFirstName(), student.getLastName(), student.getGender(), student.getDateOfBirth());

            if (findStudent(student.getCnp()) >= 0) {
                System.out.println(student.toString() + " already in the student list!");
                return false;
            }
            return myStudentList.add(student);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void retrieveStudent (String age){

        try {
            retrieveStudentValidation(age);
            Integer intAge = Integer.parseInt(age);
            for (int i = 0; i < myStudentList.size(); i++) {

                int calculatedAge = getAge(currentDate, myStudentList.get(i).getDateOfBirth());
                if (calculatedAge == intAge) {
                    System.out.println((i + 1) + ". " + myStudentList.get(i).toString() + " -> " + calculatedAge + " years old.");
                }
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void retrieveStudentValidation (String age) throws ValidationException {

        if (age.matches(REGEX_AGE)) {
            throw new ValidationException("The value is not a number or you've entered a negative number!");
        }
    }

    private int getAge(String currentDate, String birthday) {

        int d1 = Integer.parseInt(currentDate);
        int d2 = Integer.parseInt(birthday);
        int age = (d1-d2) / CALCULATE_AGE;

        return age;
    }


    public void removeStudent (String cnp) {
        int position = findStudent(cnp);
        
        try {
        	removeStudentValidation(cnp);
        	
        	if (position >= 0) {
        		removeStudent(position);
        	} else {
        		System.out.println("There's no student with CNP " + cnp);
        	}
        }
        catch (ValidationException e) {
        	System.out.println(e.getMessage());
        }
    }

    private void addStudentValidation (String firstName, String lastName, String gender, String dateOfBirth) throws ValidationException {

        int convertedDob = Integer.parseInt(dateOfBirth);
        int convertedCurrent = Integer.parseInt(currentDate);

        if (firstName == "" || lastName == "" || firstName == null || lastName == null) {
            throw new ValidationException("Error: The first or the last name is empty!");
        }
        if (gender.equalsIgnoreCase("M") && gender.equalsIgnoreCase("F")) {
            throw  new ValidationException("Error: Gender needs to be either 'M' or 'F'");
        }
        if (convertedDob <= INVALID_DATE || convertedDob >= convertedCurrent) {
            throw new ValidationException("Error: You have enter an invalid date!");
        }
    }
    
    private void removeStudentValidation (String cnp) throws ValidationException {
    	if (cnp == "") {
    		throw new ValidationException("The ID is empty, the student does not exist!");
    	}
    	
    }

    private int findStudent (String cnp) {

        for (int i = 0; i < myStudentList.size(); i++) {
            Student student = myStudentList.get(i);

            if (student.getCnp().equals(cnp)) {
                return i;
            }
        }
        return -1;
    }

    private void removeStudent(int position) {
        myStudentList.remove(position);
    }
}