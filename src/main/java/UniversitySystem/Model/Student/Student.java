package UniversitySystem.Model.Student;

import UniversitySystem.Model.Enrollment.Enrollment;
import UniversitySystem.Model.Major.Major;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/*
 * Represents a student enrolled in the university.
 * Contains personal information such as name, email, major, and academic standing.
 * A student can be enrolled in multiple courses (through the Enrollment table).
 */
@Entity
@Table(name = "student")
public class Student {
    // Unique identifier for each student
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    // Full name of the student (must be unique and not blank)
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Name field cannot be empty")
    private String name;

    // Student's email address (must be unique and not blank)
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Email field cannot be empty")
    private String email;

    // The major the student is enrolled in
    @ManyToOne
    @JoinColumn(name = "majorId", nullable = true)
    @JsonBackReference("major-student")
    private Major major;

    // Student's academic standing (e.g., Freshman, Sophomore)
    @NotBlank(message ="Academic standing cannot be null")
    private String academic_standing;

    // List of courses this student is enrolled in (via Enrollment)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("student-enrollments")
    private List<Enrollment> enrollment;


    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Major getMajor() {
        return major;
    }
    public void setMajor(Major major) {
        this.major = major;
    }
    public String getAcademic_standing() {
        return academic_standing;
    }
    public void setAcademic_standing(String academic_standing) {
        this.academic_standing = academic_standing;
    }
    public List<Enrollment> getEnrollment() {
        return enrollment;
    }
    public void setEnrollment(List<Enrollment> enrollment) {
        this.enrollment = enrollment;
    }

}
