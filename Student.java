import java.util.HashMap;
import java.util.Map;

public class Student {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String faculty;
    private final Map<String, Integer> marks = new HashMap<>();
    private double averageMark;

    public Student(String id, String firstName, String lastName, String faculty) {
        if (!id.matches("\\d{6}") || id.charAt(0) == '0') {
            throw new IllegalArgumentException("ID must be exactly 6 digits and cannot start with 0");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
    }

    public void addMark(String subject, int mark) {
        if (mark < 2 || mark > 5) {
            throw new IllegalArgumentException("Mark must be an integer between 2 and 5");
        }
        marks.put(subject, mark);
        calculateAverage();
    }

    public void changeMark(String subject, int newMark) {
        addMark(subject, newMark);
    }

    private void calculateAverage() {
        double sum = 0.0;
        for (int mark : marks.values()) {
            sum += mark;
        }
        averageMark = sum / marks.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", marks=" + marks +
                ", averageMark=" + averageMark +
                '}';
    }

    // getters and setters omitted for brevity

    public static void main(String[] args) {
        Student[] students = new Student[5];

        // Create students with random values
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(
                    String.format("%06d", (int) (Math.random() * 1_000_000)),
                    "FirstName" + i,
                    "LastName" + i,
                    "Faculty" + i
            );

            // Add random marks
            for (int j = 0; j < 5; j++) {
                students[i].addMark("Subject" + j, 2 + (int) (Math.random() * 4));
            }

            System.out.println(students[i]);

            // Change a mark
            students[i].changeMark("Subject0", 5);

            System.out.println(students[i]);
        }
    }
}