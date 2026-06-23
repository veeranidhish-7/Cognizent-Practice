package MVCPatternExample;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("VIT-101", "Veera", "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        controller.updateView();

        System.out.println("Updating student grade...");
        System.out.println();
        controller.setStudentGrade("A+");

        controller.updateView();
    }
}
