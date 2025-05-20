package test.jetbrains.spring7.demospring7.registrar;

public class Person {

    public final String name;

    public Person() {
        this("unknown");
    }

    public Person(String name) {
        this.name = name;
    }
}
