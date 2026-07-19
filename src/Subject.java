import java.util.ArrayList;

public class Subject {
    private int subjectId;
    private String subjectName;
    private ArrayList<Mark> marks;

    public Subject(int subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.marks = new ArrayList<Mark>();
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public ArrayList<Mark> getMarks() {
        return marks;
    }

    public void addMark(Mark mark) {
        marks.add(mark);
    }

    public void removeMark(Mark mark) {
        marks.remove(mark);
    }
}