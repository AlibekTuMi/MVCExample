package Controler.Interfaces;
import java.util.List;

import Model.Core.Student;
public interface iGetModel {
    public List<Student> getStudents();

    String promodel(String msg);

    boolean deleteStud(int id);

    void createStudent(String name, int age, int id);

    
}
