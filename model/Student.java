package model;

public class Student {
    public int rollNo;
    public String name;
    public String email;
    public double marks;

    public Student(int rollNo, String name, String email, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return rollNo + "," + name + "," + email + "," + marks;
    }
}
