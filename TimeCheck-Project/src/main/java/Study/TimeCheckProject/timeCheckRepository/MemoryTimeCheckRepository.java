package Study.TimeCheckProject.timeCheckRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MemoryTimeCheckRepository implements TimeCheckRepository{
    ArrayList<TimeCheck> timeList;

    public MemoryTimeCheckRepository() {
        timeList = new ArrayList<TimeCheck>();
    }

    @Override
    public void setTime(boolean startEnd) {
        if (startEnd == true) {
            timeList.add(new TimeCheck(LocalDate.now(),LocalTime.now()));
        }
        else {
            LocalDate date = timeList.get(timeList.size()).getDate();
            if (LocalDate.now().isEqual(date)) {
                timeList.get(timeList.size()).setEndTime(LocalTime.now());
            }
        }
    }

    @Override
    public LocalTime getTime(LocalDate date, boolean startEnd) {
        return timeList.get(timeList.size()-1).getStartTime();
    }
}
