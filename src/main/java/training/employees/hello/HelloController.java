package training.employees.hello;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
    1. lépés: component scan felolvassa az osztályokat, a Spring Application Context
    indulásának első fázisában
    2. lépés: a Spring észreveszi, hogy a Service-nek paraméter nélküli konstruktora,
    a Controllernek paraméteres, Service-t tartalmazó konstruktora van
    3. lépés: felépít egy gráfot: Controller -> Service
    4. lépés: Spring indulásának 2. fázisában először
        HelloService services = new HelloService();
        HelloController controller = new HelloController(service);
 */
@Controller
@AllArgsConstructor
public class HelloController {

    private HelloService helloService;

    // Constructor injection
//    public HelloController(HelloService helloService) {
//        this.helloService = helloService;
//    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET) // requestmapping
    @ResponseBody // a visszatérési értéket írja bele a http válaszba
    public String sayHello() {
//        HelloService helloService = new HelloService(); // TILOS!
        // Delegál
        return helloService.sayHello().toUpperCase();
    }


    @RequestMapping(value = "/favourite-color", method = RequestMethod.GET)
    @ResponseBody
    public String getFavouriteColor() {
        return helloService.getFavouriteColor();
    }
}
