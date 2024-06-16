import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\nStudent Grade Tracker");
            System.out.println("1. Add Student");
            System.out.println("2. View Student Grades");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    students.add(addStudent(sc));
                    break;
                case 2:
                    viewStudentGrades(students);
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static Student addStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        ArrayList<Integer> grades = new ArrayList<>();
        while (true) {
            System.out.print("Enter grade : ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int grade = Integer.parseInt(input);
                grades.add(grade);
             } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'done'.");
            }
        }

        return new Student(name, grades);
    }

  
    public static void viewStudentGrades(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("\nStudent: " + student.getName());
            System.out.print("Grades: ");
            for (int grade : student.getGrades()) {
                System.out.print(grade + " ");
            }
            System.out.println("\nAverage: " + student.calculateAverage());
            System.out.println("Highest: " + student.findHighest());
            System.out.println("Lowest: " + student.findLowest());
        }
    }
}

class Student {
    public String name;
    public ArrayList<Integer> grades;

    public Student(String name, ArrayList<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public int findHighest() {
        if (grades.isEmpty()) {
            return 0;
        }
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public int findLowest() {
        if (grades.isEmpty()) {
            return 0;
        }
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}