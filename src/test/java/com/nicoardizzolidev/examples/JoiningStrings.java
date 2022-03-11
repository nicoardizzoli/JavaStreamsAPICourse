package com.nicoardizzolidev.examples;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningStrings {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        // "Anna, John, Marcos, Helena, Yasmin"
        StringBuilder stringNuevo = new StringBuilder();


        Iterator<String> iterator = names.iterator();
        names.forEach(name -> {
            iterator.next();
            String s = name.substring(0, 1).toUpperCase();
            String restoDelName = name.substring(1);

            stringNuevo.append(s).append(restoDelName);
            if (iterator.hasNext()) {
                stringNuevo.append(", ");
            }
        });

        System.out.println(stringNuevo);

    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");

        // "Anna, John, Marcos, Helena, Yasmin"
        String stringStream = names.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .collect(Collectors.joining(", "));

        System.out.println(stringStream);


    }

}
