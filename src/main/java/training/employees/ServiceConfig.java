package training.employees;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public HelloService helloService() {
        return new HelloService();
    }

}
