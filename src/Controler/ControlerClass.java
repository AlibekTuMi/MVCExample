package Controler;

import Model.Core.Student;
import java.util.ArrayList;
import java.util.List;

import Controler.Interfaces.iGetModel;
import Controler.Interfaces.iGetView;


public class ControlerClass {
    
    private iGetModel model;
    private iGetView view;
    private List<Student> studBuff = new ArrayList<>();

    public ControlerClass(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }


    private boolean testData(List<Student> students){
        if(students.size()>0){
            return true;
        }
        return false;
    }

    public void update(){

        studBuff = model.getStudents();
        if(testData(studBuff)){

            view.printAllStudents(studBuff);
        }
        else{
            view.listStudentEmpty();
        }
    }

    public void run(){
        System.out.println();
        Command com = Command.NONE;
        boolean getNewInter = true;
        while (getNewInter) {
            String command = view.prompt(view.getCommangMessage());
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    view.getExit();
                    getNewInter = false;
                    break;
            
                case LIST:
                    update();
                    break;

                    // Команда позволяет удалить студента по id из списка студентов
                case DELETE:
                    update();
                    String command1 = model.promodel(view.comModMsg());
                    try {
                        int deletID = Integer.parseInt(command1);
                        model.deleteStud(deletID);
                    } catch (Exception e) {
                        
                    }
                    break;

                    // Моя доработка. Данная команда позволяет добавить студента в список студентов
                case CREATE:
                    String name = view.prompt(view.inputNewStudentName());
                    String age = view.prompt(view.inputNewStudentAge());
                    int newAge = Integer.parseInt(age);
                    String id = view.prompt(view.inputNewStudentId());
                    int newId = Integer.parseInt(id);
                    model.createStudent(name,newAge,newId);
                    break;

                default: 
                    view.commandIsEmpty();
            }
        }
    }
}
