package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import Controler.Interfaces.iGetModel;
import Model.Core.Student;

public class ModelClassFileEng implements iGetModel {
    private String fileName;

    public ModelClassFileEng(String fileName) {
        this.fileName = fileName;
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            try (BufferedReader reader = new BufferedReader(fr)) {

                String line = reader.readLine();
                while (line != null) {
                    String[] param = line.split(" ");
                    Student pers = new Student(param[0], Integer.parseInt(param[1]), Integer.parseInt(param[2]));
                    students.add(pers);
                    line = reader.readLine();
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public void saveAllStudentToFile(List<Student> students) {
        try (FileWriter fw = new FileWriter(fileName, false)) {

            for (Student pers : students) {
                fw.write(pers.getName() + " " + pers.getAge() + " " + pers.getId());
                fw.append('\n');
            }
            fw.flush();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Функция считывания данных от пользователя
    @Override
    public String promodel(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }

   
    
    @Override
    public boolean deleteStud(int id) {
        List<Student> students = getStudents();
        boolean findStudent = false;

        for (int i = 0; i < students.size(); i++) {
            if (id==students.get(i).getId()) {
                findStudent = true;
                students.remove(students.get(i));
            } 
        }
        if (findStudent==false) {
           
            System.out.println("\nThe student with this ID is not on the list\n");
           
        }
             
        saveAllStudentToFile(students);
        return findStudent;
    }

    
    @Override
    public void createStudent(String name, int age, int id) {
        List<Student> students = getStudents();
        boolean uniqueId = true;
        for (int i = 0; i < students.size(); i++) {
            if (id==students.get(i).getId()) {
                System.out.println("This ID is already occupied, enter a unique one!\n");
                uniqueId = false;
            } 
        }
        if (uniqueId==true) {
            Student newStudent = new Student(name, age, id);
            students.add(newStudent);
            saveAllStudentToFile(students);
            for (Student student : students) {
                System.out.println(student);
            }
        }

    }

}
