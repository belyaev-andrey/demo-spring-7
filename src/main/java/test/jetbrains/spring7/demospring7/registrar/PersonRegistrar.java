package test.jetbrains.spring7.demospring7.registrar;

import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

import java.util.UUID;

public class PersonRegistrar implements BeanRegistrar {

    @Override
    public void register(BeanRegistry registry, Environment env) {
        registry.registerBean(UUID.randomUUID().toString(), Person.class);
        registry.registerBean(UUID.randomUUID().toString(), Person.class, personSpec -> {
            personSpec.supplier(ctx -> new Person("Joe"));
        });
    }
}
