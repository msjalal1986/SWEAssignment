package edu.mum.cs.cs425.demos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args)
    {
        ArrayList<Student> studentList = new ArrayList<>();

        studentList.add(new Student(110001, "Dave", LocalDate.parse("11/18/1951", DateTimeFormatter.ofPattern("MM/dd/yyyy"))));
        studentList.add(new Student(110002, "Anna",  LocalDate.parse("12/07/1990", DateTimeFormatter.ofPattern("MM/dd/yyyy"))));
        studentList.add(new Student(110003, "Erica", LocalDate.parse("01/31/1974", DateTimeFormatter.ofPattern("MM/dd/yyyy"))));
        studentList.add(new Student(110004, "Carlos",LocalDate.parse("08/22/2009", DateTimeFormatter.ofPattern("MM/dd/yyyy"))));
        studentList.add(new Student(110005, "Bob", LocalDate.parse("03/05/1990", DateTimeFormatter.ofPattern("MM/dd/yyyy"))));

        System.out.println("Print list of Students : ");
        System.out.println("-------------------------------------");
        printListOfStudents(studentList);

        System.out.println("Print Platinum  Student  List :");
        System.out.println("-------------------------------------");
        getListOfPlatinumAlumniStudents(studentList);


        System.out.println("Print MIU , World, MIU World based of 7 and 9 multiplicity :");
        System.out.println("-------------------------------------");
        int[] inputArray = { 3, 5, 7, 10, 14, 15, 21, 25, 30, 35 };
        printHelloWorld(inputArray);



        System.out.println("Print Second Best :");
        System.out.println("-------------------------------------");
        int[] inputArray1 = {1, 2, 3, 4, 5};
        int[] inputArray2 = {19, 9, 11, 0, 12};
        System.out.println("2nd biggest in exam1: " + findSecondBiggest(inputArray1));
        System.out.println("2nd biggest in exam2: " + findSecondBiggest(inputArray2));
    }
    public static void  printListOfStudents(ArrayList<Student> students)
    {
        students.sort(Comparator.comparing(Student::getName));

        for (var student : students) {
            System.out.println("Id: "+ student.getStudentId()+" " +"Name: " +student.getName()+" "+ "Admission Date : "+student.getDateOfAdmission());
        }
    }
    public static void  getListOfPlatinumAlumniStudents(ArrayList<Student> students)
    {
        ArrayList<Student> platinumStudents =  new ArrayList<>();

        for (Student student : students) {
            if (java.time.Year.now().getValue() - student.getDateOfAdmission().getYear() >= 30) {
                platinumStudents.add(student);
            }
        }

        platinumStudents.sort(Comparator.comparing(Student::getDateOfAdmission).reversed());

        for(Student platinumStudent: platinumStudents){
            System.out.println("Id: "+ platinumStudent.getStudentId()+" " +"Name: " + platinumStudent.getName()+" "+ "Admission Date : "+ platinumStudent.getDateOfAdmission());
        }
    }
    public static void printHelloWorld(int[] numbers)
    {
        for (int number : numbers)
        {
            if (number % 5 == 0 && number % 7 == 0)
            {
                System.out.println("HelloWorld");
            }
            else if (number % 5 == 0)
            {
                System.out.println("Hello");
            }
            else if (number % 7 == 0)
            {
                System.out.println("World");
            }
            else
            {
                System.out.println( "This  is invalid  input element  of  an  array  " +number);
            }
        }
    }
    public static int findSecondBiggest(int[] numbers) {
        if (numbers == null || numbers.length < 2)
        {
            throw new IllegalArgumentException("The Array should  have at least two elements");
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int number : numbers)
        {
            if (number > firstMax)
            {
                secondMax = firstMax;
                firstMax = number;
            } else if (number > secondMax && number != firstMax)
            {
                secondMax = number;
            }
        }
        return secondMax;
    }
}
