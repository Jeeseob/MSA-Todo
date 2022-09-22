package Study.TimeCheckProject.control;

import Study.TimeCheckProject.repository.timeCheckRepository.MemoryTimeCheckRepository;
import Study.TimeCheckProject.member.TimeCheck;
import Study.TimeCheckProject.repository.timeCheckRepository.TimeCheckRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class RESTApi {
    TimeCheckRepository timeCheckRepositroy = new MemoryTimeCheckRepository();
    @GetMapping("/start")
    public TimeCheck start() {
        timeCheckRepositroy.setTime(true);
        return timeCheckRepositroy.getTimeCheck(LocalDate.now());
    }
    @GetMapping("/end")
    public TimeCheck end() {
        timeCheckRepositroy.setTime(false);
        return timeCheckRepositroy.getTimeCheck(LocalDate.now());
        //timeCheckRepositroy.getTime(LocalDate.now(),false);
    }

    @GetMapping("/all")
    public ArrayList<TimeCheck> all() {
        return timeCheckRepositroy.getAllTime();
    }
}
