package test.jetbrains.spring7.demospring7;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "test.jetbrains.spring7.demospring7")
public class AppConfig {
}
