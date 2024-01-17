package Controler.Interfaces;

import java.util.List;

import Model.Core.Student;

public interface iGetView {
    
    // метод вывода списка студентов
    void printAllStudents(List<Student> students);

    // функция, которая принимает воодимые данные от функции getCommangMessage
    String prompt(String msg);

    // метод который указывает что список студентов пустой
    void listStudentEmpty();

    // метод указывающий что команда не проработана
    void commandIsEmpty();

    // функция выводит на терминал данные 
    String getCommangMessage();

    // метод закрытия программы
    void getExit();

    // функция запроса данных у пользователя
    String comModMsg();

    // функция запроса данных у пользователя
    String inputNewStudentName();

    // функция запроса данных у пользователя
    String inputNewStudentAge();

    // функция запроса данных у пользователя
    String inputNewStudentId();


    
}
