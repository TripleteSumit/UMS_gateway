import java.util.ArrayList;
import java.util.List;

class CourseProfile {
    private String abbr, name;

    CourseProfile(String abbr, String name) {
        this.abbr = abbr;
        this.name = name;
    }

    public String getCourseName() {
        return name;
    }

    public String getCourseAbbr() {
        return abbr;
    }

}

class StudentAlreadyEnrolledException extends Exception {
    public StudentAlreadyEnrolledException(String msg) {
        super(msg);
    }
}

public class Course extends CourseProfile {

    private int seat;
    private List<Student> enrolledStudent;

    Course(String abbr, String name, int seat) {
        super(abbr, name);
        this.seat = seat;
        enrolledStudent = new ArrayList<>();
    }

    public void studentEnrollment(Student st, CourseAdmin ca) throws StudentAlreadyEnrolledException {
        if (ca.isStudentEnrolled(st)) {
            // System.out.println("Student is already enrolled in " +
            // ca.getEnrolledStudentCourseName(st));
            // return;
            throw new StudentAlreadyEnrolledException(
                    "Student is already enrolled in " + ca.getEnrolledStudentCourseName(st));
        }
        if (enrolledStudent.size() == seat) {
            System.out.println("All seats are full. No more seats are available.");
            return;
        }
        enrolledStudent.add(st);
        ca.enrolledStudent(st, getCourseName());
        System.out.println("Successfully enrolled in the course. Thank you for enrolling");
    }

    public void RevokeEnrollment(Student st) {
        if (!enrolledStudent.contains(st)) {
            System.out.println("Student is not registed on this course. Please verify the information again.");
        } else {
            enrolledStudent.remove(st);
            System.out.println("Successfully deregisted from this course.");
            System.out.println("----------** Student Profile **-----------");
            System.out.println("Name: " + st.getName());
            System.out.println("Regd_no: " + st.getRegdNo());
        }
    }

    public List<Student> getEnrolledStudent() {
        return enrolledStudent;
    }

}
