package com.nicoardizzolidev.examples;

import com.nicoardizzolidev.beans.Car;
import com.nicoardizzolidev.beans.Person;
import com.nicoardizzolidev.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Sorting {

    @Test
    public void sortingSteamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> peopleSorted = people.stream()
                .map(Person::getFirstName)
                .sorted()
                .toList();

        peopleSorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> peopleSorted = people.stream()
                .map(Person::getFirstName)
                .sorted(Comparator.reverseOrder())
                .toList();

        peopleSorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfObjets() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> listaOrdenada = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getAge))
                .toList();
        listaOrdenada.forEach(System.out::println);
    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();
        List<Car> blueAndExpensiveCars = cars.stream()
                .filter(c -> c.getColor().equals("Blue"))
                .sorted(Comparator.comparing(Car::getPrice))
                .limit(10)
                .collect(Collectors.toList());

                blueAndExpensiveCars.forEach(System.out::println);
    }

}
