package Study.TimeCheckProject.timeCheckRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface TimeCheckRepository<T> {
    // 시간 저장
    void setTime(boolean startEnd);
    // 저장된 시간 반환
    LocalTime getTime(LocalDate date, boolean startEnd);
    ArrayList<T> getAllTime();
    TimeCheck getTimeCheck(LocalDate date);

}
