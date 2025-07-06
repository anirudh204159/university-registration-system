package UniversitySystem.Model.Schedule;

import UniversitySystem.Model.Course.Course;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.sql.Time;

/*
 * Represents a scheduled instance of a course (like a section or lecture).
 * Includes details like semester, day, time, and room number.
 * Each schedule is associated with one course.
 */
@Entity
@Table(name = "schedule")
public class Schedule {
    // Unique identifier for the course schedule
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleId;

    // Room number where the course is held (must be unique)
    @Column(unique = true)
    @NotNull(message = "Room number cannot be left null")
    private int roomNum;

    // Day of the week when the class meets (e.g., MONDAY)
    private Day day;

    // Time of day the class starts (e.g., 10:00 AM)
    private Time time;

    // Semester when the course is offered (e.g., "Fall 2025")
    private String semester;

    // Course that this schedule is associated with
    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    @JsonBackReference
    private Course course;

    public Schedule() {

    }
    public int getScheduleId() {
        return scheduleId;
    }
    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }
    public int getRoomNum() {
        return roomNum;
    }
    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }
    public Day getDay() {
        return day;
    }
    public void setDay(Day day) {
        this.day = day;
    }
    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }
    public String getSemester() {
        return semester;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }


}
