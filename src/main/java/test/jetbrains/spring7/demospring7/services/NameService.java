package test.jetbrains.spring7.demospring7.services;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class NameService {

    private final Faker faker = new Faker(Locale.ENGLISH);

    public List<String> generateNames() {
        return java.util.stream.IntStream.range(0, 10)
                .mapToObj(i -> faker.name().fullName())
                .collect(java.util.stream.Collectors.toList());
    }

}
