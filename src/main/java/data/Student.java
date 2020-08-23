package data;

public class Student {

    private String prename;
    private String surname;
    private int course;
    private int matriculationNumber;


    public Student(String prename, String surname, int course, int matriculationNumber) {
        this.prename = prename;
        this.surname = surname;
        this.course = course;
        this.matriculationNumber = matriculationNumber;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "prename='" + prename + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                ", matriculationNumber=" + matriculationNumber +
                '}';
    }

    private static final String[] prenames = {"A", "B", "C", "D", "E", "F", "G"};
    private static final int[] matriculation = {4, 10, 3, 5, 1, 18, 11};
  //  private static final  Random rd = new Random();



    public static Student[] getDummyData() {
        Student[] students = new Student[prenames.length];
        for (int i = 0; i < students.length; i ++) {
            students[i] = getStudent(i);
        }
        return students;
    }

    private static Student getStudent(int position) {
        return new Student(prenames[position], "S_" + prenames[position], (int) (Math.random()*100000), matriculation[position]);
    }
}
