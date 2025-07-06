package UniversitySystem.DTO.ProfessorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Professor {
    private int professorId;
    private String name;
    private String email;
    private String department;
}
