package com.example;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class testExample {
    @Test
    void testFlatMap(){
        try {
            Stream<String> stringStream = Files.lines(Paths.get("test/test.txt"));


            long noOfWords = Files.lines(Paths.get("test/test.txt"))
                    .flatMap(l-> Arrays.stream(l.split(" +")))
                    .distinct()
                    .count();
            System.out.println("No Of Words: "+noOfWords);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
