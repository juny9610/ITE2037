
public class Student implements Comparable<Student> {
    public Student(String name, String department, String studentId, String phoneNum){
        this.name = name;
        this.department = department;
        this.studentId = studentId;
        this.phoneNum = phoneNum;
    }

    @Override
    public int compareTo(Student student) {
        if(this.name.compareTo(student.name) < 0) return -1;
        return 1;
    }

    public String getFullInfo(){
        return "name: " + this.name + ", "
                + "department: " + this.department + ", "
                + "studentId: " + this.studentId + ", "
                + "phoneNum: " + this.phoneNum;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){ return this.name; }
    public String getDepartment() { return this.department; }
    public String getStudentId() { return this.studentId; }
    public String getPhoneNum() { return this.phoneNum; }

    private String name;
    private String department;
    private String studentId;
    private String phoneNum;
}

