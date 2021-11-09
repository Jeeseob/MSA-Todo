package Study.TimeCheckProject;

import Study.TimeCheckProject.timeCheckRepository.MemoryTimeCheckRepository;
import Study.TimeCheckProject.timeCheckRepository.TimeCheckRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
public class RESTApi {
    @GetMapping("/home")
    public LocalTime home() {
        TimeCheckRepository timeCheckRepositroy = new MemoryTimeCheckRepository();
        timeCheckRepositroy.setTime(true);
        return timeCheckRepositroy.getTime(LocalDate.now(),true);
    }
}
