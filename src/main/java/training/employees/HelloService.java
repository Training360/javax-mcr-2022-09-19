package training.employees;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//@Service
@AllArgsConstructor
public class HelloService {

    private TimeMachine timeMachine;

    public String sayHello() {
        return "Hello from devtools service! " + timeMachine.now();
    }
}
