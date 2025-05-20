package test.jetbrains.spring7.demospring7.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String sayHello() {
        return "Hello World";
    }

    public String sayHello(String name) {
        return "Hello %s".formatted(name);
    }
}
