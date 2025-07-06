package UniversitySystem.DTO.EnrollmentDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnrollmentDTO {
    private int enrollmentId;
    private int studentId;
    private int courseId;
    private boolean status;
    private int waitlistPosition;
}
