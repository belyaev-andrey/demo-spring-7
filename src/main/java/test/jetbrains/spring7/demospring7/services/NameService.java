package test.jetbrains.spring7.demospring7.services;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

@Service
public class NameService {

    private Faker faker = new Faker(Locale.ENGLISH);

    public List<String> generateNames() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            names.add(faker.name().fullName());
        }
        return names;
    }

}
