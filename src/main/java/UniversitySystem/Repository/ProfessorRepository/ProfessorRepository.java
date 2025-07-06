package UniversitySystem.Repository.ProfessorRepository;

import UniversitySystem.Model.Professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
