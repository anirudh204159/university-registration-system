package UniversitySystem.Service;

import UniversitySystem.Model.Student.Student;
import UniversitySystem.Repository.StudentRepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    // Get a single student by ID
    public Optional<Student> getStudentById(int id) {
        return studentRepo.findById(id);
    }

    // Add a new student
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    // Update a student's information
    public Optional<Student> updateStudent(int id, Student studentDetails) {
        return studentRepo.findById(id)
                .map(existingStudent -> {
                    existingStudent.setName(studentDetails.getName());
                    existingStudent.setEmail(studentDetails.getEmail());
                    existingStudent.setAcademic_standing(studentDetails.getAcademic_standing());
                    existingStudent.setMajor(studentDetails.getMajor());
                    return studentRepo.save(existingStudent);
                });
    }

    // Delete a student
    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }
}
