import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add Student
    public void addStudent(Student student) {

        for (Student s : students) {
            if (s.getRollNo() == student.getRollNo()) {
                System.out.println("Student with Roll Number "
                        + student.getRollNo()
                        + " already exists.");
                return;
            }
        }

        students.add(student);
        System.out.println("Student added successfully!");
    }

    // View All Students
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.printf("%-8s %-20s %-6s %-6s %-6s %-6s %-10s %-5s\n",
                "Roll", "Name", "M1", "M2", "M3", "Total", "Percentage", "Grade");

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Search Student
    public Student searchStudent(int rollNo) {

        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                return s;
            }
        }

        return null;
    }

    public void searchStudentByName(String name) {

        boolean found = false;

        for (Student s : students) {

            if (s.getName().equalsIgnoreCase(name)) {

                System.out.println(s);
                found = true;

            }

        }

        if (!found) {
            System.out.println("Student not found.");
        }

    }

    // Delete Student
    public boolean deleteStudent(int rollNo) {

        Student student = searchStudent(rollNo);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }

    // Update Student
    public boolean updateStudent(int rollNo, String name, int m1, int m2, int m3) {

        Student student = searchStudent(rollNo);

        if (student == null)
            return false;

        student.setName(name);
        student.setMarks1(m1);
        student.setMarks2(m2);
        student.setMarks3(m3);

        return true;
    }

    // Sort by Percentage
    public void sortStudents() {

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getPercentage(), s1.getPercentage());
            }
        });

        System.out.println("Students sorted successfully.");
    }

    // Display Rank List
    public void displayRankList() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        sortStudents();

        System.out.println("\n========== RANK LIST ==========");

        int rank = 1;

        for (Student s : students) {

            System.out.printf("Rank %-3d %-20s Percentage : %.2f%% Grade : %s\n",
                    rank++,
                    s.getName(),
                    s.getPercentage(),
                    s.getGrade());
        }
    }

    public void displayTopper() {

        if (students.isEmpty()) {

            System.out.println("No records found.");
            return;

        }

        Student topper = students.get(0);

        for (Student s : students) {

            if (s.getPercentage() > topper.getPercentage()) {

                topper = s;

            }

        }

        System.out.println("\n========== TOPPER ==========");

        System.out.println("Roll Number : " + topper.getRollNo());
        System.out.println("Name        : " + topper.getName());
        System.out.println("Percentage  : "
                + String.format("%.2f", topper.getPercentage()));
        System.out.println("Grade       : " + topper.getGrade());

    }

    public void classStatistics() {

        if (students.isEmpty()) {

            System.out.println("No student records.");
            return;

        }

        double totalPercentage = 0;

        double highest = students.get(0).getPercentage();

        double lowest = students.get(0).getPercentage();

        int pass = 0;

        for (Student s : students) {

            totalPercentage += s.getPercentage();

            if (s.getPercentage() > highest)
                highest = s.getPercentage();

            if (s.getPercentage() < lowest)
                lowest = s.getPercentage();

            if (!s.getGrade().equals("F"))
                pass++;

        }

        System.out.println("\n========== CLASS REPORT ==========");

        System.out.println("Total Students : "
                + students.size());

        System.out.println("Average Percentage : "
                + String.format("%.2f",
                totalPercentage / students.size()));

        System.out.println("Highest Percentage : "
                + highest);

        System.out.println("Lowest Percentage : "
                + lowest);

        System.out.println("Pass Percentage : "
                + String.format("%.2f",
                (pass * 100.0) / students.size()) + "%");

    }


    // Getter
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Setter
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}

