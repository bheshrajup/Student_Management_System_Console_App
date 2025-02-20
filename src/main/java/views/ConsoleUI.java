package views;

import models.Student;
import services.StudentService;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final StudentService studentService;
    private final Scanner scanner;

    // Constructor initializes StudentService and Scanner
    public ConsoleUI() {
        this.studentService = new StudentService();
        this.scanner = new Scanner(System.in);
    }

    // Display menu options
    private void showMenu() {
        System.out.println("\n==============================");
        System.out.println(" STUDENT MANAGEMENT SYSTEM");
        System.out.println("==============================");
        System.out.println("1️⃣  Add Student");
        System.out.println("2️⃣  View All Students");
        System.out.println("3️⃣  Update Student");
        System.out.println("4️⃣  Delete Student");
        System.out.println("5️⃣  Search Student by ID");
        System.out.println("🔵  Exit");
        System.out.print("👉 Enter your choice: ");
    }


    // Method to run the UI
    public void start() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudentById();
                    break;
                case 0:
                    System.out.println("👋 Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a new student
    private void addStudent() {
        System.out.print("📌 Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("📌 Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("📌 Enter course: ");
        String course = scanner.nextLine();

        studentService.addStudent(name, age, course);
    }

    // Method to view all students
       private void viewAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("🚨 No students found!");
            return;
        }

        // Define column widths
        int idWidth = 6, nameWidth = 25, ageWidth = 5, courseWidth = 20;
        String format = "| %-"+idWidth+"s | %-"+nameWidth+"s | %-"+ageWidth+"s | %-"+courseWidth+"s |\n";

        // Table Header
        System.out.println("\n📜 STUDENT LIST:");
        System.out.println("+" + "-".repeat(idWidth + 2) + "+" + "-".repeat(nameWidth + 2) + "+" + "-".repeat(ageWidth + 2) + "+" + "-".repeat(courseWidth + 2) + "+");
        System.out.printf(format, "ID", "Name", "Age", "Course");
        System.out.println("+" + "-".repeat(idWidth + 2) + "+" + "-".repeat(nameWidth + 2) + "+" + "-".repeat(ageWidth + 2) + "+" + "-".repeat(courseWidth + 2) + "+");

        // Table Rows
        for (Student student : students) {
            System.out.printf(format, student.getId(), student.getName(), student.getAge(), student.getCourse());
        }

        // Table Footer
        System.out.println("+" + "-".repeat(idWidth + 2) + "+" + "-".repeat(nameWidth + 2) + "+" + "-".repeat(ageWidth + 2) + "+" + "-".repeat(courseWidth + 2) + "+");
    }



    // Method to update a student's details
    private void updateStudent() {
        System.out.print("🔍 Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student existingStudent = studentService.getStudentById(id);
        if (existingStudent == null) {
            System.out.println("🚨 Student not found!");
            return;
        }

        System.out.print("📌 Enter new name (or press Enter to keep '" + existingStudent.getName() + "'): ");
        String name = scanner.nextLine();
        if (name.trim().isEmpty()) name = existingStudent.getName();

        System.out.print("📌 Enter new age (or 0 to keep '" + existingStudent.getAge() + "'): ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (age == 0) age = existingStudent.getAge();

        System.out.print("📌 Enter new course (or press Enter to keep '" + existingStudent.getCourse() + "'): ");
        String course = scanner.nextLine();
        if (course.trim().isEmpty()) course = existingStudent.getCourse();

        studentService.updateStudent(id, name, age, course);
    }

    // Method to delete a student
    private void deleteStudent() {
        System.out.print("🗑 Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        studentService.deleteStudent(id);
    }

    // Method to search for a student by ID
    private void searchStudentById() {
        System.out.print("🔍 Enter student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = studentService.getStudentById(id);
        if (student == null) {
            System.out.println("🚨 Student not found!");
        } else {
            System.out.println("\n✅ Student Found:");
            System.out.println("-----------------------------");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Course: " + student.getCourse());
            System.out.println("-----------------------------");
        }
    }
}
