package main.java.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Jamie", Gender.male),
                new Person("Gina", Gender.female),
                new Person("Berta", Gender.female)
        );

        for (Person person : people) {
            System.out.println(person);
        }

        List<Person> girls = new ArrayList<>();

        // Imperative approach
        for (Person person : people) {
            if (person.gender == Gender.female) {
                girls.add(person);
            }
        }

        System.out.println("------ girls");
        for (Person female : girls) {
            System.out.println(female);
        }

        System.out.println("------ Declarative");
        // Declarative approach
        List<Person> girls2 = people.stream()
                .filter(person -> person.gender == Gender.female)
                .toList();

        girls2.stream().forEach(System.out::println);

    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        male,
        female
    }
}
