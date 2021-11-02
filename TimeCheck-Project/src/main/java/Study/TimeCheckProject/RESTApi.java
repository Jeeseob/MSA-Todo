package Study.TimeCheckProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTApi {
    @GetMapping("/home")
    public String Test() {
        return "Server Test";
    }
}
