public class Student {

    private int rollNo;
    private String name;
    private int marks1;
    private int marks2;
    private int marks3;
    private int total;
    private double percentage;
    private String grade;

    // Constructor
    public Student(int rollNo, String name, int marks1, int marks2, int marks3) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;

        calculateResult();
    }

    // Calculate Total, Percentage and Grade
    public void calculateResult() {

        total = marks1 + marks2 + marks3;

        percentage = total / 3.0;

        if (percentage >= 90)
            grade = "A+";
        else if (percentage >= 80)
            grade = "A";
        else if (percentage >= 70)
            grade = "B";
        else if (percentage >= 60)
            grade = "C";
        else if (percentage >= 50)
            grade = "D";
        else
            grade = "F";
    }

    // Getters
    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getMarks1() {
        return marks1;
    }

    public int getMarks2() {
        return marks2;
    }

    public int getMarks3() {
        return marks3;
    }

    public int getTotal() {
        return total;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getGrade() {
        return grade;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks1(int marks1) {
        this.marks1 = marks1;
        calculateResult();
    }

    public void setMarks2(int marks2) {
        this.marks2 = marks2;
        calculateResult();
    }

    public void setMarks3(int marks3) {
        this.marks3 = marks3;
        calculateResult();
    }

    @Override
    public String toString() {

        return String.format(
                "%-8d %-20s %-6d %-6d %-6d %-6d %-10.2f %-5s",
                rollNo,
                name,
                marks1,
                marks2,
                marks3,
                total,
                percentage,
                grade);
    }

}
