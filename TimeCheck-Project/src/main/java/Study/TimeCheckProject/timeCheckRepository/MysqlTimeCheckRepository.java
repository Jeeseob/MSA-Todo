package Study.TimeCheckProject.timeCheckRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MysqlTimeCheckRepository implements TimeCheckRepository{
    @Override
    public void setTime(boolean startEnd) {

    }

    @Override
    public LocalTime getTime(LocalDate date, boolean startEnd) {
        return null;
    }

    @Override
    public ArrayList getAllTime() {
        return null;
    }

    @Override
    public TimeCheck getTimeCheck(LocalDate date) {
        return null;
    }
}
