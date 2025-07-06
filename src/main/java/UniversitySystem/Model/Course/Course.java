package UniversitySystem.Model.Course;

import UniversitySystem.Model.Enrollment.Enrollment;
import UniversitySystem.Model.Professor.Professor;
import UniversitySystem.Model.Schedule.Schedule;
import UniversitySystem.Model.Major.Major;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/*
 * Represents a course offered in the university system.
 * Each course is tied to a specific professor and major.
 * A course can have multiple schedules (sections) and enrollments (students registered).
 */
@Entity
@Table(name = "course")
public class Course {
    // Unique identifier for each course (Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    // Title of the course (e.g., "Data Structures")
    @NotBlank(message = "Title field cannot be empty")
    private String title;

    // Number of credit hours the course is worth
    @NotNull(message = "Credit field cannot be null")
    private int credits;

    // The major that this course belongs to (e.g., Computer Science)
    @ManyToOne
    @JoinColumn(name = "majorId", nullable = false)
    @JsonBackReference
    private Major major;

    // The professor teaching this course
    @ManyToOne
    @JoinColumn(name = "professorId", nullable = false)
    @JsonBackReference
    private Professor professor;

    // All enrollments (students) registered for this course
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Enrollment> enrollment;

    // Schedule(s) (day/time/room) for when the course meets
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Schedule> schedules;

    public Course() {

    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public Major getMajor() {
        return major;
    }
    public void setMajor(Major major) {
        this.major = major;
    }
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public List<Schedule> getSchedules() {
        return schedules;
    }
    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
    public List<Enrollment> getEnrollment() {
        return enrollment;
    }
    public void setEnrollment(List<Enrollment> enrollment) {
        this.enrollment = enrollment;
    }
}
