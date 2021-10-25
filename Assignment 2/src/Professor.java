
public class Professor implements Comparable<Professor>{
    public Professor(String name, String department, String professorId, int classNum){
        this.name = name;
        this.department = department;
        this.professorId = professorId;
        this.classNum = classNum;
    }

    @Override
    public int compareTo(Professor professor) {
        if(this.classNum < professor.classNum) return -1;
        return 1;
    }

    public String getFullInfo(){
        return "name: " + this.name + ", "
                + "department: " + this.department + ", "
                + "professor Id: " + this.professorId + ", "
                + "classNum: " + Integer.toString(this.classNum);
    }
    public String getName() { return this.name; }
    public String getDepartment() { return department; }
    public String getProfessorId() { return professorId; }
    public int getClassNum() { return classNum; }

    private String name;
    private String department;
    private String professorId;
    private int classNum;
}

