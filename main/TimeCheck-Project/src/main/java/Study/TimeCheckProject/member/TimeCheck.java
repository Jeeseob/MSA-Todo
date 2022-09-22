package Study.TimeCheckProject.member;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Entity
public class TimeCheck {
    @Id
    private LocalDate date;
    private LocalTime startTime;
    // 중간에 멈추는 부분 (순공시간 체크를 위함)
    private ArrayList<LocalTime> pauseTimes;
    private ArrayList<LocalTime> restartTimes;
    // 공부 종료
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

    public ArrayList<LocalTime> getPauseTime() {
        return pauseTimes;
    }

    public void setPauseTime(ArrayList<LocalTime> pauseTime) {
        this.pauseTimes = pauseTime;
    }

    public ArrayList<LocalTime> getRestartTime() {
        return restartTimes;
    }

    public void setRestartTime(ArrayList<LocalTime> restartTime) {
        this.restartTimes = restartTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
