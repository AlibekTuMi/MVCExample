package Model;

import java.util.List;
import java.util.Scanner;

import Controler.Interfaces.iGetModel;
import Model.Core.Student;

public class ModelClassList implements iGetModel {
    private List<Student> students;

    public ModelClassList(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String promodel(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println();
        return in.nextLine();
    }

    @Override
    public boolean deleteStud(int id) {
        List<Student> students = getStudents();
        boolean findStudent = false;

        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).getId()) {
                findStudent = true;
                students.remove(students.get(i));
            }
        }
        if (findStudent == false) {
            System.out.println("\nСтудента с таким ID нет в списке\n");
        }

        return findStudent;
    }

    @Override
    public void createStudent(String name, int age, int id) {
        List<Student> students = getStudents();
        boolean uniqueId = true;
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).getId()) {
                System.out.println("Такой ID уже занят, введите уникальный!\n");
                uniqueId = false;
            }
        }
        if (uniqueId == true) {
            Student newStudent = new Student(name, age, id);
            students.add(newStudent);
            for (Student student : students) {
                System.out.println(student);
            }
        }

    }

}
