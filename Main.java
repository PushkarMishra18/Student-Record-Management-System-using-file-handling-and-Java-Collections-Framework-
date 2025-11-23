package main;

import java.util.*;
import model.Student;
import util.MarksComparator;
import fileops.FileHandler;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Scanner sc) {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(roll, name, email, marks));
        System.out.println("Student Added.\n");
    }

    public static void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s.rollNo + " | " + s.name + " | " + s.email + " | " + s.marks);
        }
    }

    public static void sortByMarks() {
        if (students.isEmpty()) {
            System.out.println("No records to sort.");
            return;
        }
        Collections.sort(students, new MarksComparator());
        System.out.println("Sorted by marks (High → Low).");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FileHandler.loadFromFile(students);

        while (true) {
            System.out.println("1. View Records");
            System.out.println("2. Add Student");
            System.out.println("3. Sort by Marks");
            System.out.println("4. Random File Read");
            System.out.println("5. Save & Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) viewAll();
            else if (choice == 2) addStudent(sc);
            else if (choice == 3) sortByMarks();
            else if (choice == 4) FileHandler.randomRead();
            else if (choice == 5) {
                FileHandler.saveToFile(students);
                System.out.println("Goodbye!");
                break;
            } 
            else System.out.println("Invalid option.");
        }
    }
}
