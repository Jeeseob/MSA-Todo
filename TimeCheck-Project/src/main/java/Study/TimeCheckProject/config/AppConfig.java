package Study.TimeCheckProject.config;

import Study.TimeCheckProject.repository.timeCheckRepository.MemoryTimeCheckRepository;
import Study.TimeCheckProject.repository.timeCheckRepository.TimeCheckRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TimeCheckRepository timeCheckRepository() {
        return new MemoryTimeCheckRepository();
    }

}
