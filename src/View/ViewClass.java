package View;

import java.util.List;
import java.util.Scanner;

import Controler.Interfaces.iGetView;
import Model.Core.Student;

public class ViewClass implements iGetView{

    // метод вывода списка студентов
    public void printAllStudents(List<Student> students){
        System.out.println("----------------Список студентов-----------------");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("-------------------------------------------------");
    }

    // функция, которая принимает воодимые данные от функции getCommangMessage
    @Override
    public String prompt(String msg) {
       Scanner in = new Scanner(System.in);
       System.out.println();
       return in.nextLine();
    }

    // метод который указывает что список студентов пустой
    @Override
    public void listStudentEmpty() {
        System.out.println("Список студенотв пуст(((");
    }

    // метод указывающий что команда не проработана
    @Override
    public void commandIsEmpty() {
        System.out.println("Команда не проработана)");
    }

    // функция выводит на терминал данные
    @Override
    public String getCommangMessage() {
        System.out.println("Доступны команды:\nLIST - список студентов\nDELETE - удалить студента по ID\nEXIT - выход из программы\nCREATE - добавить нового студента в список\n");
        System.out.println("Не проработанные команды: \nREAD\nUPDATE\n");
        System.out.println("Введите команду");
        return "Введите команду";
    }

    // метод закрытия программы
    @Override
    public void getExit() {
        System.out.println("Программа закрывается!");
    }

    // функция запроса данных у пользователя
    @Override
    public String comModMsg() {
        return "Введите ID удаляемого студента: ";
    }

    // функция запроса данных у пользователя
    @Override
    public String inputNewStudentName() {
        return "Введите имя нового студента";
    }

    // функция запроса данных у пользователя
    @Override
    public String inputNewStudentAge() {
        return "Введите возраст нового студента";
    }

    // функция запроса данных у пользователя
    @Override
    public String inputNewStudentId() {
        return "Введите уникальный ID нового студента";
    }

}
