package com.nicoardizzolidev.examples;

import com.nicoardizzolidev.beans.Car;
import com.nicoardizzolidev.beans.Person;
import com.nicoardizzolidev.beans.PersonDTO;
import com.nicoardizzolidev.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> dtos = people.stream()
                .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        double average = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(-1);
        System.out.println(average);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        int sum1 = Arrays.stream(integers).reduce(0, (a, b) -> a + b);

        //con method reference
        int sum2 = Arrays.stream(integers).reduce(0, Integer::sum);
    }
}

