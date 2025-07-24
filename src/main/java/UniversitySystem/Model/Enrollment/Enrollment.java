package UniversitySystem.Model.Enrollment;

import UniversitySystem.Model.Course.Course;
import UniversitySystem.Model.Student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/*
 * Represents a student's enrollment in a course.
 * Tracks the student's status (enrolled or waitlisted) and their position on the waitlist if applicable.
 * Acts as a join table between Student and Course.
 */
@Entity
@Table(name = "enrollment")
public class Enrollment {
    // Unique identifier for each enrollment record
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollment_id;

    // Whether the student is enrolled (true) or on the waitlist (false)
    private boolean status;

    // If the student is waitlisted, their position in line
    private int waitlistPosition;

    // The student associated with this enrollment
    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    @JsonBackReference("student-enrollments")
    private Student student;


    // The course associated with this enrollment
    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    @JsonBackReference
    private Course course;


    public Enrollment() {

    }

    public int getEnrollment_id() {
        return enrollment_id;
    }
    public void setEnrollment_id(int enrollment_id) {
        this.enrollment_id = enrollment_id;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getWaitlistPosition() {
        return waitlistPosition;
    }
    public void setWaitlistPosition(int waitlistPosition) {
        this.waitlistPosition = waitlistPosition;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
}
