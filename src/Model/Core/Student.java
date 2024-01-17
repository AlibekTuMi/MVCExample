package Model.Core;

public class Student extends Person implements Comparable<Student>{

    private int id;
    private static int generalId;

    static{
        generalId = 0;
    }

    public Student(String name, int age, int id) {
        super(name, age);
        this.id = id;
        generalId++;
    }
    public Student(String name, int age) {
        this(name, age, generalId);
        
    }

    public int getId() {
        return id;
    }
    
    @Override
    public int compareTo(Student o) {
        // System.out.println(super.getName() + "-" + o.getName());
        if (super.getAge()<o.getAge()) {
            return -1;
        }
        else if (super.getAge()>o.getAge()) {
            return 1;
        }
        if (this.getId()<o.getId()) {
            return -1;
        }
        else if (this.getId()>o.getId()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString()+ String.format("; Id - %d",getId());
    }
    
}
