package training.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import training.employees.hello.HelloController;
import training.employees.hello.HelloService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloControllerTest {

    @Mock
    HelloService helloService;

    @InjectMocks
    HelloController helloController;

    @Test
    void testSayHello() {
        when(helloService.sayHello()).thenReturn("hello");
        assertEquals("HELLO", helloController.sayHello());
    }
}
