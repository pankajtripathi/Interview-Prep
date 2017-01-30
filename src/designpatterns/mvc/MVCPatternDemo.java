package com.practice.designpatterns.mvc;

import java.util.Scanner;

/**
 * Created by pankajtripathi on 10/16/16.
 */

// Model
class Student{
    private String name;
    private int rollno;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
}


//View
class StudentView{
    public void printStudentDetails(String name, int rollno){
        Scanner s = new Scanner(System.in);
        System.out.println("Student Details:");
        System.out.println("Name: "+name);
        System.out.println("Roll-No: "+rollno);
        System.out.println();
    }
}

//Controller
class StudentController{
    private Student model;
    private StudentView view;

    StudentController(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }

    public String getName() {
        return model.getName();
    }

    public void setName(String name) {
        model.setName(name);
    }

    public int getRollno() {
        return model.getRollno();
    }

    public void setRollno(int rollno) {
        model.setRollno(rollno);
    }

    public void updateView(){
        view.printStudentDetails(model.getName(), model.getRollno());
    }

}

public class MVCPatternDemo {
    public static void main(String[] args) {

        Student model = getStudentRecord();
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setName("Dave");

        controller.updateView();

    }

    private static Student getStudentRecord(){
        Student student = new Student();
        student.setName("Robert");
        student.setRollno(42);
        return student;
    }
}
