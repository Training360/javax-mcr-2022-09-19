package training.employees.hello;

import lombok.AllArgsConstructor;

//@Service
@AllArgsConstructor
public class HelloService {

    private TimeMachine timeMachine;

    public String sayHello() {
        return "Hello from devtools service! " + timeMachine.now();
    }
}
