package Study.TimeCheckProject.timeCheckRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeCheck {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public TimeCheck(LocalDate date, LocalTime startTime) {
        this.date = date;
        this.startTime = startTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
