package training.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import training.employees.hello.HelloController;
import training.employees.hello.TimeMachine;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class HelloControllerIT {

    @Autowired
    HelloController helloController;

    @MockBean
    TimeMachine timeMachine;

    @Test
    void testSayHello() {
        when(timeMachine.now()).thenReturn(LocalDateTime.parse("2022-01-01T10:00:00"));

        var message = helloController.sayHello();
//        assertTrue(message.startsWith("HELLO FROM SERVICE!"),
//                "Doesn't start with the given message");
        assertEquals("HELLO FROM DEVTOOLS SERVICE! 2022-01-01T10:00", message);
    }
}
