package UniversitySystem.Repository.CourseRepository;

import UniversitySystem.Model.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>{
}