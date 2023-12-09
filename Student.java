public class Student {
    private String regd_no, name;

    Student(String regd_no, String name) {
        this.regd_no = regd_no;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getRegdNo() {
        return regd_no;
    }

    public String toString() {
        return "Name: " + name + "\n" + "Registration Number: " + regd_no;
    }

}
