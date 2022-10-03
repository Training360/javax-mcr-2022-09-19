package training.employees.hello;

import java.time.LocalDateTime;

public class MockedTimeMachine extends TimeMachine{

    @Override
    public LocalDateTime now() {
        return LocalDateTime.parse("2022-01-01T10:00:00");
    }
}
