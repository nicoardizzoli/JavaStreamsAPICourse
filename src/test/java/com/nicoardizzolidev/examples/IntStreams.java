package com.nicoardizzolidev.examples;


import com.nicoardizzolidev.beans.Person;
import com.nicoardizzolidev.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class IntStreams {

    @Test
    public void range() throws Exception {
        System.out.println("With fori");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        System.out.println("with inStream exclusive"); //no incluye el 2do numero
        IntStream.range(0, 10).forEach(System.out::println); //method reference se llama esto de los ::

        System.out.println("with inStream inclusive"); //incluye los dos.
        IntStream.rangeClosed(0, 10).forEach(System.out::println); //method reference se llama esto de los ::
    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size()).forEach(i -> {
            System.out.println(people.get(i));
        });

    }

    @Test
    public void intStreamIterate()  {
        IntStream.iterate(0, operand -> operand + 1)
                .limit(10)
                .forEach(System.out::println);
    }
}
