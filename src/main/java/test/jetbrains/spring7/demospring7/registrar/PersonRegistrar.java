package test.jetbrains.spring7.demospring7.registrar;

import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;
import test.jetbrains.spring7.demospring7.services.NameService;

import java.util.UUID;

public class PersonRegistrar implements BeanRegistrar {

    private final NameService nameService;

    public PersonRegistrar(NameService nameService) {
        this.nameService = nameService;
    }

    @Override
    public void register(BeanRegistry registry, Environment env) {
        nameService.generateNames().forEach(name ->
                registry.registerBean(UUID.randomUUID().toString(), Person.class,
                        personSpec -> personSpec.supplier(ctx -> new Person(name)))
        );
    }
}
