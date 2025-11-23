package fileops;

import java.io.*;
import java.util.*;
import model.Student;

public class FileHandler {

    public static final String FILE_NAME = "students.txt";

    public static void loadFromFile(ArrayList<Student> students) {
        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                System.out.println("File not found. Creating new file...");
                file.createNewFile();
            }

            System.out.println("\nFile Information:");
            System.out.println("Name: " + file.getName());
            System.out.println("Path: " + file.getAbsolutePath());
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("------------------------");

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                students.add(new Student(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        Double.parseDouble(parts[3])
                ));
            }
            br.close();

            System.out.println("Loaded " + students.size() + " records.\n");

        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    public static void saveToFile(ArrayList<Student> students) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME));
            for (Student s : students) {
                pw.println(s);
            }
            pw.close();
            System.out.println("\nRecords saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    public static void randomRead() {
        try {
            RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "r");
            System.out.println("\nReading first 40 bytes randomly:");
            for (int i = 0; i < Math.min(40, raf.length()); i++) {
                System.out.print((char) raf.read());
            }
            System.out.println("\n");
            raf.close();
        } catch (Exception e) {
            System.out.println("Random read failed.");
        }
    }
}
