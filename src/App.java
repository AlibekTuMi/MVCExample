import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controler.ControlerClass;
import Controler.Interfaces.iGetModel;
import Controler.Interfaces.iGetView;
import Model.ModelClassFile;
import Model.ModelClassFileEng;
import Model.ModelClassList;
import Model.Core.Student;
import View.ViewClass;
import View.ViewClassEng;

public class App {
    public static void main(String[] args) throws Exception {
       
        Student student1 = new Student("Андрей", 19, 33);
        Student student2 = new Student("Сергей", 20, 35);
        Student student3 = new Student("Константин", 20, 12);
        Student student4 = new Student("Илья", 19, 66);
        Student student5 = new Student("Анна", 23, 17);
        Student student6 = new Student("Ольга", 22, 39);
        Student student7 = new Student("Светлана", 18, 84);
        Student student8 = new Student("Ульяна", 21, 81);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student6);
        students.add(student4);
        students.add(student5);
        students.add(student8);
        students.add(student7);
        students.add(student3);

        // Данный код позволяет выбрать язык при запуске контролёра
        Scanner scanner = new Scanner(System.in); 
        
        System.out.println("Выберите язык:");
        System.out.println("Select a language");
        System.out.println("1 ENGLISH");
        System.out.println("2 Русский");
        
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Your choice ENGLISH");
                iGetView viewClassEng = new ViewClassEng();
                ModelClassFileEng modelClassFileEng = new ModelClassFileEng("StudentDB.txt");
                modelClassFileEng.saveAllStudentToFile(students);
                ControlerClass controlerClassEng = new ControlerClass(modelClassFileEng, viewClassEng);
                controlerClassEng.run();
                break;
            case 2:
                System.out.println("Вы выбрали РУССКИЙ");
                iGetView viewClassRus = new ViewClass();
                ModelClassFile modelClassFileRus = new ModelClassFile("StudentDB.txt");  
                modelClassFileRus.saveAllStudentToFile(students);
                ControlerClass controlerClassRus = new ControlerClass(modelClassFileRus, viewClassRus);
                controlerClassRus.run();
                break;
           
        }
        scanner.close();
       

    }
}
