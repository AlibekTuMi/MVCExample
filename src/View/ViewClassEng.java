package View;

import java.util.List;
import java.util.Scanner;

import Controler.Interfaces.iGetView;
import Model.Core.Student;

public class ViewClassEng implements iGetView{
    public void printAllStudents(List<Student> students){
        System.out.println("----------------List Students-----------------");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("-------------------------------------------------");
    }

    @Override
    public String prompt(String msg) {
       Scanner in = new Scanner(System.in);
       System.out.println(msg);
       return in.nextLine();
    }

    @Override
    public void listStudentEmpty() {
        System.out.println("List Students is empty(((");
    }

    @Override
    public void commandIsEmpty() {
        System.out.println("Command is not realization)");
    }

    @Override
    public String getCommangMessage() {
        System.out.println("Сommands are available:\n\nLIST - list students\nDELETE - delete a student by ID\nEXIT - exit programm\nCREATE - add new student in list\n");
        System.out.println("Incomplete commands: \nREAD\nUPDATE\n");
      return "Input command";
    }

    @Override
    public void getExit() {
        System.out.println("Program close!");
    }

    @Override
    public String comModMsg() {
        return "Enter the ID of the student you are deleting: ";
    }

    @Override
    public String inputNewStudentName() {
        return "Input name new student";
    }

    @Override
    public String inputNewStudentAge() {
        return "Input age new student";
    }

    @Override
    public String inputNewStudentId() {
        return "Input unique ID new student";
    }

    


}
