package UniversitySystem.Model.Major;

import UniversitySystem.Model.Course.Course;
import UniversitySystem.Model.Student.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/*
 * Represents a student's academic major (e.g., Computer Science, Biology).
 * Each major is part of a department and can be associated with multiple courses.
 */

@Entity
@Table(name = "major")
public class Major {
    // Unique identifier for each major (Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int majorId;

    // Name of the major (e.g., Biology, Computer Science)
    @NotBlank(message = "Major field cannot be empty")
    private String majorName;

    // Department this major belongs to (e.g., Engineering, Arts & Sciences)
    @NotBlank(message = "Department field cannot be empty")
    private String department;

    // List of courses that fall under this major
    @OneToMany(mappedBy = "major")
    @JsonManagedReference
    private List<Course> courses;

    @OneToMany(mappedBy = "major")
    @JsonManagedReference("major-student")
    private List<Student> students;


    public Major() {

    }
    public int getMajorId(){
        return majorId;
    }
    public void setMajorId(int majorId){
        this.majorId = majorId;
    }
    public String getMajorName(){
        return majorName;
    }
    public void setMajorName(String majorName){
        this.majorName = majorName;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public List<Course> getCourses(){
        return courses;
    }
    public void setCourses(List<Course> courses){
        this.courses = courses;
    }
    public List<Student> getStudents(){
        return students;
    }
    public void setStudents(List<Student> students){
        this.students = students;
    }
}
