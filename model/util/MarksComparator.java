package util;

import java.util.Comparator;
import model.Student;

public class MarksComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.marks, s1.marks);
    }
}
