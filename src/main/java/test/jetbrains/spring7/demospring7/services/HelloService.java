package test.jetbrains.spring7.demospring7.services;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import test.jetbrains.spring7.demospring7.registrar.Person;
import test.jetbrains.spring7.demospring7.registrar.PersonRegistrar;

@Service
public class HelloService {

    private final NameService nameService;

    public HelloService(NameService nameService) {
        this.nameService = nameService;
    }

    public String sayHello() {
        return "Hello World";
    }

    public String sayHello(String name) {
        return "Hello %s".formatted(name);
    }

    @EventListener
    private void on(ContextRefreshedEvent event) {
        AnnotationConfigWebApplicationContext ctx =  (AnnotationConfigWebApplicationContext)event.getApplicationContext();
        ctx.register(new PersonRegistrar(nameService));
        if (ctx.getBeansOfType(Person.class).isEmpty()) {
            ctx.refresh();
        }
    }
}
