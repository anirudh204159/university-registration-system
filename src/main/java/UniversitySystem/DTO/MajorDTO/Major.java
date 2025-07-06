package UniversitySystem.DTO.MajorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Major {
    private int majorCode;
    private String majorName;
    private String department;
}
