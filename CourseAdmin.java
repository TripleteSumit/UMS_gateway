import java.util.HashMap;
import java.util.Map;

public class CourseAdmin {
    Map<String, String> allEnrolledStudent;

    public CourseAdmin() {
        allEnrolledStudent = new HashMap<>();
    }

    public boolean isStudentEnrolled(Student st) {
        return allEnrolledStudent.containsKey(st.getRegdNo());
    }

    public void enrolledStudent(Student st, String abbr) {
        allEnrolledStudent.put(st.getRegdNo(), abbr);
    }

    public void revokeStudent(Student st) {
        allEnrolledStudent.remove(st.getRegdNo());
    }

    public String getEnrolledStudentCourseName(Student st) {
        return allEnrolledStudent.get(st.getRegdNo());
    }
}