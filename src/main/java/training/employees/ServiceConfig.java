package training.employees;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public TimeMachine timeMachine() {
        return new TimeMachine();
    }
    @Bean
    public HelloService helloService() {
        return new HelloService(timeMachine());
    }

}
