import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        // Load data from file
        manager.setStudents(FileManager.loadFromFile());

        int choice;

        do {

            System.out.println("==========================================");
            System.out.println("     STUDENT RESULT MANAGEMENT SYSTEM");
            System.out.println("==========================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Sort Students");
            System.out.println("8. Display Rank List");
            System.out.println("9. Display Topper");
            System.out.println("10. Class Statistics");
            System.out.println("11. Save Data");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Enter a number: ");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    int m1, m2, m3;

                    do {

                        System.out.print("Enter Marks in Subject 1 (0-100): ");
                        m1 = sc.nextInt();

                    } while (m1 < 0 || m1 > 100);

                    do {

                        System.out.print("Enter Marks in Subject 2 (0-100): ");
                        m2 = sc.nextInt();

                    } while (m2 < 0 || m2 > 100);

                    do {

                        System.out.print("Enter Marks in Subject 3 (0-100): ");
                        m3 = sc.nextInt();

                    } while (m3 < 0 || m3 > 100);

                    manager.addStudent(new Student(roll, name, m1, m2, m3));

                    break;

                case 2:

                    manager.viewStudents();
                    break;

                case 3:

                    System.out.print("Enter Roll Number: ");
                    roll = sc.nextInt();

                    Student student = manager.searchStudent(roll);

                    if (student == null)
                        System.out.println("Student not found.");
                    else
                        System.out.println(student);

                    break;



                case 4:

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");

                    String searchName = sc.nextLine();

                    manager.searchStudentByName(searchName);

                    break;

                case 5:

                    System.out.print("Enter Roll Number: ");
                    roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    name = sc.nextLine();



                    do {

                        System.out.print("Enter Marks in Subject 1 (0-100): ");
                        m1 = sc.nextInt();

                    } while (m1 < 0 || m1 > 100);

                    do {

                        System.out.print("Enter Marks in Subject 2 (0-100): ");
                        m2 = sc.nextInt();

                    } while (m2 < 0 || m2 > 100);

                    do {

                        System.out.print("Enter Marks in Subject 3 (0-100): ");
                        m3 = sc.nextInt();

                    } while (m3 < 0 || m3 > 100);

                    if (manager.updateStudent(roll, name, m1, m2, m3))
                        System.out.println("Student Updated Successfully.");
                    else
                        System.out.println("Student Not Found.");

                    break;

                case 6:

                    System.out.print("Enter Roll Number: ");
                    roll = sc.nextInt();

                    if (manager.deleteStudent(roll))
                        System.out.println("Student Deleted Successfully.");
                    else
                        System.out.println("Student Not Found.");

                    break;

                case 7:

                    manager.sortStudents();
                    manager.viewStudents();

                    break;

                case 8:

                    manager.displayRankList();

                    break;

                case 9:

                    manager.displayTopper();

                    break;

                case 10:

                    manager.classStatistics();

                    break;

                case 11:

                    FileManager.saveToFile(manager.getStudents());

                    break;

                case 12:

                    FileManager.saveToFile(manager.getStudents());

                    System.out.println("Thank You!");
                    System.out.println("Data Saved Successfully.");

                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 12);

        sc.close();
    }
}