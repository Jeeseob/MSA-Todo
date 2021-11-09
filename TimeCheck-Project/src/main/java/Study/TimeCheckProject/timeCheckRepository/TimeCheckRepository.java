package Study.TimeCheckProject.timeCheckRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface TimeCheckRepository {
    // 시간 저장
    void setTime(boolean startEnd);

    // 저장된 시간 반환
    LocalTime getTime(LocalDate date, boolean startEnd);

}
