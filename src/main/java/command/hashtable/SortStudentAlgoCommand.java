package command.hashtable;

import command.ICommand;
import data.Student;
import sort.MatrNrComparator;
import sort.Sortable;

public class SortStudentAlgoCommand implements ICommand {

    private Sortable<Student> algorithm;

    public SortStudentAlgoCommand(Sortable<Student> algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public void execute() {
        Student[] arr = Student.getDummyData();
        algorithm.sort(arr, new MatrNrComparator());
        printStudents(arr, "Sorted list:");
    }

    @Override
    public String toString() {
        return algorithm.toString();
    }

    private static void printStudents(Student[] studentArr, String headline) {
        System.out.println(headline);
        for (int i = 0; i < studentArr.length; i++) {
            System.out.println((i + 1) + ". " + studentArr[i]);
        }
        System.out.println();
    }
}
