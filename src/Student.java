import java.util.ArrayList;
public class Student {
    private int id;
    private String name;
    private ArrayList<Subject> subjects ;


    public Student(int id , String name){
        this.id = id;
        this.name = name;
        this.subjects = new ArrayList<Subject>();
   
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Subject> getSubjects(){
        return subjects;
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }
    public void removeSubject(Subject subject){
        subjects.remove(subject);
    }

}
