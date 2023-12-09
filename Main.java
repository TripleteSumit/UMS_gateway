import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CourseAdmin ca = new CourseAdmin();

        Course cs1 = new Course("CSE", "Computer Science", 180);
        Course cs2 = new Course("ECE", "Electronics and Communication Engineering", 30);

        enrollStudentsInCourse(cs1, ca, scanner);
        enrollStudentsInCourse(cs2, ca, scanner);

        List<Student> enrolledStudentsCs1 = cs1.getEnrolledStudent();
        displayEnrolledStudents(enrolledStudentsCs1);

        List<Student> enrolledStudentsCs2 = cs2.getEnrolledStudent();
        displayEnrolledStudents(enrolledStudentsCs2);

        scanner.close();

        System.out.println("Thank you for using UMS\n\n");
    }

    private static void enrollStudentsInCourse(Course course, CourseAdmin ca, Scanner scanner) {
        System.out.println("Enrolling students in " + course.getCourseName() + " - " + course.getCourseAbbr());

        while (true) {
            System.out.println("Enter student details:");
            System.out.print("Enter student REGD NO: ");
            String studentId = scanner.nextLine();
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();

            Student student = new Student(studentId, studentName);

            try {
                course.studentEnrollment(student, ca);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Do you want to enroll another student? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                break;
            }
        }
    }

    private static void displayEnrolledStudents(List<Student> enrolledStudents) {
        System.out.println("\t------ REPORT ------\n\n");
        for (Student student : enrolledStudents) {
            System.out.println("\t" + student.getName() + "\t" + student.getRegdNo());
        }
        System.out.println("\n\n\t------ Ending ------\n\n");
    }
}