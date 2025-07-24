import java.util.ArrayList;
import java.util.Scanner;

class Student{
    String name;
    double grade;

    Student(String name, double grade){
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradesManager{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        for (int i = 0; i < count; i++){
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter grade for " + name + ": ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            students.add(new Student(name, grade));
        }

        // Calculate statistics
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        for(Student s : students){
            total += s.grade;

            if(s.grade > highest){
                highest = s.grade;
                topStudent = s.name;
            }

            if(s.grade < lowest){
                lowest = s.grade;
                lowStudent = s.name;
            }
        }

        double average = total / students.size();

        // Summary Report
        System.out.println("\n========== Summary Report ==========");
        System.out.printf("Average Score: %.2f\n", average);
        System.out.println("Highest Score: " + highest + " (" + topStudent + ")");
        System.out.println("Lowest Score: " + lowest + " (" + lowStudent + ")");
        System.out.println("\nAll Students and Grades:");

        for(Student s : students){
            System.out.println(" - " + s.name + ": " + s.grade);
        }
    }
}
