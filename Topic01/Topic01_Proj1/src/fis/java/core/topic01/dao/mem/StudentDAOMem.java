package fis.java.core.topic01.dao.mem;

import fis.java.core.topic01.core.Student;
import fis.java.core.topic01.dao.ISortStrategy;
import fis.java.core.topic01.dao.IStudentDAO;

public class StudentDAOMem implements IStudentDAO {

    public final int MAX = 100;
    private Student[] students;
    private int count;
    private ISortStrategy sortStrategy;

    public StudentDAOMem(){
        this.count = 0;
        this.students = new Student[MAX];
        this.sortStrategy = new SelectionSortStrategy();
    }

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public Student remove(int code) {
        return null;
    }

    @Override
    public void display() {

    }

    @Override
    public void sort() {

    }

    public void setSortStrategy(ISortStrategy iSortStrategy) {

    }

    private class SelectionSortStrategy implements ISortStrategy {
        @Override
        public void sort(Comparable[] data, int count) {

        }
    }
}
