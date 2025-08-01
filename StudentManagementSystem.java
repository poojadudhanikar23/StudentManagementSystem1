import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static class Student {
        int id;
        String name;
        int age;

        // Constructor
        Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        // Display student details
        void display() {
            System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            if (choice == 1) {
                // Add a new student
                System.out.print("Enter student ID: ");
                int id = input.nextInt();
                input.nextLine(); // to consume leftover newline
                System.out.print("Enter student name: ");
                String name = input.nextLine();
                System.out.print("Enter student age: ");
                int age = input.nextInt();

                Student s = new Student(id, name, age);
                students.add(s);
                System.out.println("Student added successfully!");

            } else if (choice == 2) {
                // Show all students
                if (students.size() == 0) {
                    System.out.println("No students to show.");
                } else {
                    System.out.println("\nList of Students:");
                    for (Student s : students) {
                        s.display();
                    }
                }

            } else if (choice == 3) {
                // Remove a student by ID
                System.out.print("Enter student ID to remove: ");
                int idToRemove = input.nextInt();
                boolean found = false;

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).id == idToRemove) {
                        students.remove(i);
                        found = true;
                        System.out.println("Student removed successfully!");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found.");
                }

            } else if (choice == 4) {
                // Exit the program
                System.out.println("Exiting... Thank you!");
                break;

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        input.close();
    }
}
