package com.nicoardizzolidev.examples;


import com.nicoardizzolidev.beans.Car;
import com.nicoardizzolidev.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class StatisticsWithStreams {

    @Test
    public void count() throws Exception {
        List<Car> cars = MockData.getCars();
        long count = cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase("Ford"))
                .count();

        System.out.println(count);
    }

    @Test
    public void min() throws Exception {
        List<Car> cars = MockData.getCars();
        //el auto mas barato
        double minimoValor = cars.stream()
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0);

        System.out.println(minimoValor);
    }

    @Test
    public void max() throws Exception {
        List<Car> cars = MockData.getCars();

        double maximoValor = cars.stream()
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);

        System.out.println(maximoValor);
    }


    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();

        double average = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println(average);
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();

        double sumaDeLosValores = cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();

        System.out.println(sumaDeLosValores);
    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();

        DoubleSummaryStatistics doubleSummaryStatistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();

        System.out.println(doubleSummaryStatistics.getMax());
        System.out.println(doubleSummaryStatistics.getMin());
        System.out.println(doubleSummaryStatistics.getSum());
        System.out.println(doubleSummaryStatistics.getAverage());
        System.out.println(doubleSummaryStatistics.getCount());
    }

}