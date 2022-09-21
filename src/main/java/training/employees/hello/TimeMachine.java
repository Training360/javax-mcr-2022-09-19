package training.employees.hello;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//@Component
public class TimeMachine {

    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
