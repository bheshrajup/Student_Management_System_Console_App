package services;

import dao.StudentDAO;
import models.Student;

import java.util.List;

public class StudentService {
    private final StudentDAO studentDAO;

    // Constructor initializes StudentDAO
    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    // Method to add a student (with validation)
    public boolean addStudent(String name, int age, String course) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("❌ Name cannot be empty!");
            return false;
        }
        if (age <= 0) {
            System.out.println("❌ Age must be a positive number!");
            return false;
        }
        if (course == null || course.trim().isEmpty()) {
            System.out.println("❌ Course cannot be empty!");
            return false;
        }

        Student student = new Student(name, age, course);
        boolean success = studentDAO.addStudent(student);
        if (success) {
            System.out.println("✅ Student added successfully!");
        } else {
            System.out.println("❌ Failed to add student.");
        }
        return success;
    }

    // Method to get all students
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    // Method to update a student (with validation)
    public boolean updateStudent(int id, String name, int age, String course) {
        if (id <= 0) {
            System.out.println("❌ Invalid Student ID!");
            return false;
        }
        if (name == null || name.trim().isEmpty() || age <= 0 || course == null || course.trim().isEmpty()) {
            System.out.println("❌ Invalid input data!");
            return false;
        }

        Student student = new Student(id, name, age, course);
        boolean success = studentDAO.updateStudent(student);
        if (success) {
            System.out.println("✅ Student updated successfully!");
        } else {
            System.out.println("❌ Failed to update student.");
        }
        return success;
    }

    // Method to delete a student
    public boolean deleteStudent(int id) {
        if (id <= 0) {
            System.out.println("❌ Invalid Student ID!");
            return false;
        }

        boolean success = studentDAO.deleteStudent(id);
        if (success) {
            System.out.println("✅ Student deleted successfully!");
        } else {
            System.out.println("❌ Failed to delete student.");
        }
        return success;
    }

    // Method to get a student by ID
    public Student getStudentById(int id) {
        if (id <= 0) {
            System.out.println("❌ Invalid Student ID!");
            return null;
        }
        return studentDAO.getStudentById(id);
    }
}
