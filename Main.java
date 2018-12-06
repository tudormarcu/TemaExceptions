package com.iopo;

import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

public class Main {

    private static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        addStudentBlock();
        sortStudentByName();
        sortStudentByDob();

        LOGGER.info("This is my error!"); 

    }

    public static void addStudentBlock() {

        Student student1 = new Student("Tudor", "Marcu", "19971222", "M", "1971222073432");
        Student student2 = new Student("Petrut", "Gheorghe", "19971219", "M", "1971219073432");
        Student student3 = new Student("David", "Savin", "19961201", "M", "1961201073432");
        Student student4 = new Student("Cristian", "Mihnea", "19981213", "M", "1981213073432");
        Student student5 = new Student("Silvia", "Santha", "19951213", "F", "2951213073432");
        Student student6 = new Student("Andrei", "Cucu", "19951213", "M", "2951213073432");

        StudentRepository myStudent = new StudentRepository();

        myStudent.addStudent(student1);
        myStudent.addStudent(student2);
        myStudent.addStudent(student3);
        myStudent.addStudent(student4);
        myStudent.addStudent(student5);
        myStudent.addStudent(student6);


        myStudent.retrieveStudent("23");
        myStudent.retrieveStudent("20");
        myStudent.retrieveStudent("22");

        myStudent.removeStudent("2951213073432");
        myStudent.removeStudent("2951213073431");
        myStudent.removeStudent("");
        myStudent.retrieveStudent("23");
        myStudent.retrieveStudent("20");
        myStudent.retrieveStudent("22");

        myStudent.retrieveStudent("19");
        myStudent.retrieveStudent("-19");
        myStudent.retrieveStudent("21a");
    }

    public static void sortStudentByName() {

        Student student1 = new Student("Tudor", "Marcu", "19971222", "M", "1971222073432");
        Student student2 = new Student("Petrut", "Gheorghe", "19971219", "M", "1971219073432");
        Student student3 = new Student("David", "", "19961201", "M", "1961201073432");
        Student student4 = new Student("Cristian", "", "19981213", "M", "1981213073432");
        Student student5 = new Student("Silvia", "Santha", "19951213", "F", "2951213073432");
        System.out.println("Sorting students based on their last name:");

        Set<Student> myOrderedStudent = new TreeSet<Student>(new LastName());

        myOrderedStudent.add(student1);
        myOrderedStudent.add(student2);
        myOrderedStudent.add(student3);
        myOrderedStudent.add(student4);
        myOrderedStudent.add(student5);

        for (Student student : myOrderedStudent) {
            System.out.println(student.toString());
        }
    }

    public static void sortStudentByDob() {

        Student student1 = new Student("Tudor", "Marcu", "19971222", "M", "1971222073432");
        Student student2 = new Student("Petrut", "Gheorghe", "19971219", "M", "1971219073432");
        Student student3 = new Student("David", "Savin", "19961201", "M", "1961201073432");
        Student student4 = new Student("Cristian", "Mihnea", "19981213", "M", "1981213073432");
        Student student5 = new Student("Silvia", "Santha", "", "F", "2951213073432");

        System.out.println("Sorting students based on their date of birth:");

        Set<Student> myDobStudent = new TreeSet<Student>(new DateOfBirth());

        myDobStudent.add(student1);
        myDobStudent.add(student2);
        myDobStudent.add(student3);
        myDobStudent.add(student4);
        myDobStudent.add(student5);

        for (Student student : myDobStudent) {
            System.out.println(student.toString());
        }
    }

}