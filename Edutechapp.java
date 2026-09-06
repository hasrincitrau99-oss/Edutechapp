import java.util.Scanner;

class Student {
    private String name;
    private String studentId;
    private String major;
    private double gpa;

    public Student(String name, String studentId, String major, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // update Gpa 
    public void updateGpa(double newGpa) {
        setGpa(newGpa);
    }

    // check Graduation Status 
    public String checkGraduationStatus() {
        if (this.gpa >= 3.00) {
            return "Graduated";
        } else {
            return "Not Graduated";
        }
    }

    // calculate Predicate 
    public String calculatePredicate() {
        if (this.gpa >= 3.75) {
            return "With Praise (Cum Laude)";
        } else if (this.gpa >= 3.50) {
            return "Very Satisfactory";
        } else if (this.gpa >= 3.00) {
            return "Satisfactory";
        } else {
            return "Needs Improvement";
        }
    }

    // Display full student details
    public void displayInfo() {
        System.out.println("=== Student Data ===");
        System.out.println("Name: " + this.name);
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Major: " + this.major);
        System.out.printf("GPA: %.2f\n", this.gpa);
        System.out.println("Status: " + checkGraduationStatus());
        System.out.println("Predicate: " + calculatePredicate() + "\n");
    }
}

// Main Class
public class Edutechapp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student[] students = new Student[5];
        students[0] = new Student("Luke", "2440001", "Computer Science", 3.95);
        students[1] = new Student("Tracy", "2440002", "Information Systems", 3.68);
        students[2] = new Student("Flora", "2440003", "Computer Science", 3.90);
        students[3] = new Student("Alex", "2440004", "Industrial Engineering", 3.00);
        students[4] = new Student("Lumi", "2440005", "Accounting", 3.40);

        System.out.print("Enter the Student ID to update: ");
        String targetId = scanner.nextLine();

        System.out.print("Enter new GPA: ");
        double newGpa = scanner.nextDouble();

        boolean found = false;

        // Searching for student by ID and updating GPA
        for (Student student : students) {
            if (student.getStudentId().equals(targetId)) {
                student.updateGpa(newGpa); 
                System.out.println("Data successfully updated!\n");
                
                // Displaying updated student info and status
                student.displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + targetId + " was not found.\n");
        }

        scanner.close();
    }
}