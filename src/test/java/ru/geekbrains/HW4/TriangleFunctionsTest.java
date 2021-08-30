package ru.geekbrains.HW4;

import HW_04.TriangleFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleFunctionsTest {
    TriangleFunctions functions = new TriangleFunctions();

    @ParameterizedTest
    @CsvSource({"6,5,5,12", "3,4,5,6"})
    void testIsCheckingTheAreaOfATriangleOnTheThreeSides(Integer a, Integer b, Integer c, double value) {
        Assertions.assertEquals(functions.areaOfATriangleOnThreeSides(a, b, c), value);
    }
}
