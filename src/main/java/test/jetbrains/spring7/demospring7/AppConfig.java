package test.jetbrains.spring7.demospring7;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import test.jetbrains.spring7.demospring7.registrar.PersonRegistrar;

@Configuration
@EnableWebMvc
@Import(PersonRegistrar.class)
@ComponentScan(basePackages = "test.jetbrains.spring7.demospring7")
public class AppConfig {
}
