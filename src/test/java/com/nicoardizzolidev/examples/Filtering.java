package com.nicoardizzolidev.examples;

import com.nicoardizzolidev.beans.Car;
import com.nicoardizzolidev.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Car> cars = MockData.getCars();

        //filtrar los autos con precio menor a 20000.
        List<Car> carsLessThan20000AndYellow = cars.stream()
                .filter(car -> car.getPrice() < 20000)
                .filter(car -> car.getColor().equals("Yellow"))
                .collect(Collectors.toList());

        carsLessThan20000AndYellow.forEach(System.out::println);
    }

    @Test
    public void dropWhile() throws Exception {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("using dropWhile");

        //el drop while muestra desde que no se cumple la condicion por primera vez.
        Stream.of(2, 4, 6, 8, 9, 10, 12).dropWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
    }

    @Test
    public void takeWhile() throws Exception {
        // using filter for even numbers
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("using take while");
        //el take while recorre hasta que se no se cumpla la condicion por primera vez.
        Stream.of(2, 4, 6, 8, 9, 10, 12).takeWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
    }

    @Test
    public void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //Encuentra el primero q cumpla la condicion, devuelve un optional
        int result = Arrays.stream(numbers).filter(n -> n == 9).findFirst().orElse(-1);
        System.out.println(result);

    }

    @Test
    public void findAny() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        //igual que findFirst, pero si hay mas de un resultado te puede devolver cualquiera
        int result = Arrays.stream(numbers).filter(n -> n == 9).findAny().orElse(-1);
        System.out.println(result);
    }

    @Test
    public void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};
        //ver si todos los elementos de una lista cumplen con cierta condicion
        boolean result = Arrays.stream(even).allMatch(value -> value % 2 == 0);
    }

    @Test
    public void anyMatch() throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
        //Si algun elemento de la lista es odd
        boolean result = Arrays.stream(evenAndOneOdd).anyMatch(value -> value % 2 == 0);
    }

}



