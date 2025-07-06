package UniversitySystem.Repository.EnrollmentRepository;

import UniversitySystem.Model.Enrollment.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

}
