package training.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import training.employees.hello.HelloService;
import training.employees.hello.TimeMachine;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Teszt osztály
@ExtendWith(MockitoExtension.class)
class HelloServiceTest {

    @Mock
    TimeMachine timeMachine;

    @InjectMocks
    HelloService service;

    // Teszt metódus = teszteset
    @Test
    void testSayHello() {
        // test double előkészítése, azaz mock létrehozása
        // DDD-nek megfelelően 3 részből áll: given, when, then

        // given
//        var timeMachine = Mockito.mock(TimeMachine.class);
        Mockito.when(timeMachine.now()).thenReturn(LocalDateTime.parse("2022-01-01T10:00:00"));

//        var time = timeMachine.now();
//        System.out.println(timeMachine.getClass().getName());
//        System.out.println(time);

//        var service = new HelloService(timeMachine);

        // when
        var message = service.sayHello();

        // then: assert
        assertEquals("Hello from devtools service! 2022-01-01T10:00", message);

    }

}
