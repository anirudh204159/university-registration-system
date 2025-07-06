package UniversitySystem.DTO.ScheduleDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    private int scheduleId;
    private int courseId;
    private String semester;
    private Day day;
    private Time time;
    private int roomNum;
}
