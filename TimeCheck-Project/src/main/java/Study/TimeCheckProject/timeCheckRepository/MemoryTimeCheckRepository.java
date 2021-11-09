package Study.TimeCheckProject.timeCheckRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MemoryTimeCheckRepository implements TimeCheckRepository<TimeCheck>{
    ArrayList<TimeCheck> timeList;

    public MemoryTimeCheckRepository() {
        timeList = new ArrayList<TimeCheck>();
    }

    @Override
    public void setTime(boolean startEnd) {
        if (startEnd == true) {
            if(timeList.isEmpty()) {
                timeList.add(new TimeCheck(LocalDate.now(), LocalTime.now()));
            }
            else {
                LocalDate date = timeList.get(timeList.size() - 1).getDate();
                if (LocalDate.now().isEqual(date)) {
                } else {
                    timeList.add(new TimeCheck(LocalDate.now(), LocalTime.now()));
                }
            }
        }
        else {
            LocalDate date = timeList.get(timeList.size()-1).getDate();
            if (LocalDate.now().isEqual(date)) {
                timeList.get(timeList.size()-1).setEndTime(LocalTime.now());
            }
        }
    }

    @Override
    public LocalTime getTime(LocalDate date, boolean startEnd) {
        //이후에 LocalDate로 검색하는 형태로 변경
        if (startEnd == true) {
            return timeList.get(timeList.size() - 1).getStartTime();
        }
        else {
            return  timeList.get(timeList.size() - 1).getEndTime();
        }
    }


    @Override
    public ArrayList<TimeCheck> getAllTime() {
        return timeList;
    }
}
