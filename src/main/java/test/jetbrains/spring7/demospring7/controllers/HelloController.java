package test.jetbrains.spring7.demospring7.controllers;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import test.jetbrains.spring7.demospring7.registrar.Person;
import test.jetbrains.spring7.demospring7.registrar.PersonRegistrar;
import test.jetbrains.spring7.demospring7.services.HelloService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
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

    @GetMapping("/register")
    @ResponseBody
    public String register() {
        return applicationContext.getBeansOfType(Person.class).values().stream()
                .map(p -> p.name)
                .collect(Collectors.joining(";"));
    }

}
