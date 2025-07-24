package UniversitySystem.Controller;

import UniversitySystem.Model.Major.Major;
import UniversitySystem.Model.Student.Student;
import UniversitySystem.Repository.MajorRepository.MajorRepository;
import UniversitySystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private MajorRepository majorRepository;

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get a single student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new student
    @PostMapping
    public Student addStudent(@RequestBody UniversitySystem.DTO.StudentDTO.Student studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setAcademic_standing(studentRequest.getAcademicStanding());

        if (studentRequest.getMajorId() > 0) {
            Major major = majorRepository.findById(studentRequest.getMajorId())
                    .orElseThrow(() -> new RuntimeException("Major not found with ID: " + studentRequest.getMajorId()));
            student.setMajor(major);
        } else {
            // No major provided, leave as null
            student.setMajor(null);
        }

        return studentService.addStudent(student);
    }

    // Update a student by ID
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student studentDetails) {
        Optional<Student> updatedStudent = studentService.updateStudent(id, studentDetails);
        return updatedStudent.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
