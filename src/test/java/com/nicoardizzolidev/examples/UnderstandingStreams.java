package com.nicoardizzolidev.examples;

import com.nicoardizzolidev.beans.Person;
import com.nicoardizzolidev.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnderstandingStreams {

    @Test
    void collect() throws IOException {
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(
                        ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll
                );
        emails.forEach(System.out::println);
    }

    @Test
    public void lazy() throws Exception {
        System.out.println(
                MockData.getCars()
                        .stream()
                        .filter(car -> {
                            System.out.println("filter car " + car);
                            return car.getPrice() < 10000;
                        })
                        .map(car -> {
                            System.out.println("mapping car " + car);
                            return car.getPrice();
                        })
                        .map(price -> {
                            System.out.println("mapping price " + price);
                            return price + (price * .14);
                        })
                        .collect(Collectors.toList())
                //SI COMENTAMOS EL COLLECT NO VAMOS A TENER RESULTADOS. ESTO QUIERE DECIR QUE LOS STREAMS SON
                //LAZY Y UNICAMENTE SE EJECUTAN CUANDO SE EJECUTA UN TERMINAL OPERATOR. COMO COLLECT O TOLIST
        );
    }
}
