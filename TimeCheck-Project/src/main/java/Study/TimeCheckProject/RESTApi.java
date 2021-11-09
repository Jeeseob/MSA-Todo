package Study.TimeCheckProject;

import Study.TimeCheckProject.timeCheckRepository.MemoryTimeCheckRepository;
import Study.TimeCheckProject.timeCheckRepository.TimeCheck;
import Study.TimeCheckProject.timeCheckRepository.TimeCheckRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@RestController
public class RESTApi {
    TimeCheckRepository timeCheckRepositroy = new MemoryTimeCheckRepository();
    @GetMapping("/start")
    public LocalTime start() {
        timeCheckRepositroy.setTime(true);
        return timeCheckRepositroy.getTime(LocalDate.now(),true);
    }
    @GetMapping("/end")
    public LocalTime end() {
        timeCheckRepositroy.setTime(false);
        return timeCheckRepositroy.getTime(LocalDate.now(),false);
    }

    @GetMapping("/all")
    public ArrayList<TimeCheck> all() {
        return timeCheckRepositroy.getAllTime();
    }
}
