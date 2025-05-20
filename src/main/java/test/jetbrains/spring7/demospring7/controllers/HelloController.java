package test.jetbrains.spring7.demospring7.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.jetbrains.spring7.demospring7.registrar.Person;
import test.jetbrains.spring7.demospring7.services.HelloService;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class HelloController {

    private final HelloService helloService;
    private final ApplicationContext applicationContext;

    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
        this.helloService = helloService;
        this.applicationContext = applicationContext;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/hello";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return helloService.sayHello();
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable("name") String name) {
        return helloService.sayHello(name);
    }

    @GetMapping("/names")
    @ResponseBody
    public String names() {
        return applicationContext.getBeansOfType(Person.class).values().stream()
                .map(p -> p.name)
                .sorted()
                .collect(Collectors.joining("\n"));
    }

}
