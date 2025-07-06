package UniversitySystem.DTO.CourseDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseDTO {
    private int courseId;
    private String title;
    private int credits;
    private String major;
    private int professorId;
}
