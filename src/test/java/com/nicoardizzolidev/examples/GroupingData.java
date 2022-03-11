package com.nicoardizzolidev.examples;


import com.nicoardizzolidev.beans.Car;
import com.nicoardizzolidev.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws Exception {
        List<Car> cars = MockData.getCars();
        Map<String, List<Car>> collect = cars.stream().collect(Collectors.groupingBy(Car::getMake));

        collect.forEach((s, cars1) -> {
            System.out.println("Make: "+s);
            cars1.forEach(System.out::println);
        });
    }

    @Test
    public void groupingAndCounting() throws Exception {
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );

        names.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

}