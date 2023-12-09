import java.util.List;

public class Main {
    public static void main(String[] args) {
        CourseAdmin ca = new CourseAdmin();

        Student st1 = new Student("2001298199", "Sumit Dey");
        Student st2 = new Student("2001298199", "Ragav Das");

        Course cs1 = new Course("CSE", "Computer Science", 180);
        Course cs2 = new Course("ECE", "Electronics and Communication Engineering", 30);

        try {
            cs1.studentEnrollment(st1, ca);
            cs2.studentEnrollment(st1, ca);
            cs2.studentEnrollment(st2, ca);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Student> st = cs1.getEnrolledStudent();
        System.out.println("\t------ REPORT ------\n\n");
        for (Student student : st) {
            System.out.println("\t" + student.getName() + "\t" + student.getRegdNo());
        }
        System.out.println("\n\n\t------ Ending ------\n\n");
        System.out.println("Thank you for using UMS");

    }
}
