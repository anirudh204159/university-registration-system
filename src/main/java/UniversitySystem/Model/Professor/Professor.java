package UniversitySystem.Model.Professor;

import UniversitySystem.Model.Course.Course;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/*
 * Represents a professor in the university.
 * Each professor has a name, email, and department.
 * A professor can teach multiple courses.
 */
@Entity
@Table(name = "professor")
public class Professor {
    // Unique identifier for each professor
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professorId;

    // Full name of the professor
    @NotBlank(message = "Name field cannot be empty")
    private String name;

    // Email address of the professor
    @NotBlank(message = "Email field cannot be empty")
    private String email;

    // Department the professor belongs to
    @NotBlank(message = "Department field cannot be empty")
    private String department;

    // List of courses taught by this professor
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Course> courses = new ArrayList<>();



    public Professor() {

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public int getProfessorId(){
        return professorId;
    }
    public List<Course> getCourses(){
        return courses;
    }
    public void setCourses(List<Course> courses){
        this.courses = courses;
    }


}
