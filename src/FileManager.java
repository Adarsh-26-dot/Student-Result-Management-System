import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "students.txt";

    // Save students to file
    public static void saveToFile(ArrayList<Student> students) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student s : students) {

                writer.write(
                        s.getRollNo() + "," +
                                s.getName() + "," +
                                s.getMarks1() + "," +
                                s.getMarks2() + "," +
                                s.getMarks3());

                writer.newLine();
            }

            System.out.println("Student records saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving data.");
            e.printStackTrace();

        }
    }

    // Load students from file
    public static ArrayList<Student> loadFromFile() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);

        // Create file automatically if it doesn't exist
        try {

            if (!file.exists()) {
                file.createNewFile();
                return students;
            }

        } catch (IOException e) {

            System.out.println("Unable to create file.");
            return students;

        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int roll = Integer.parseInt(data[0]);
                String name = data[1];
                int m1 = Integer.parseInt(data[2]);
                int m2 = Integer.parseInt(data[3]);
                int m3 = Integer.parseInt(data[4]);

                students.add(new Student(roll, name, m1, m2, m3));
            }

        } catch (IOException e) {

            System.out.println("Error while reading file.");
            e.printStackTrace();

        }

        return students;
    }

}
