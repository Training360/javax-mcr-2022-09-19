package training.employees;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET) // requestmapping
    @ResponseBody // a visszatérési értéket írja bele a http válaszba
    public String sayHello() {
        return "Hello! " + LocalDateTime.now();
    }
}
