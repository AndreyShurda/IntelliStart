package com.intellias.lesson28;

import org.junit.jupiter.api.Assertions;


class CalculatorTest {
    private Calculator calculator;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @org.junit.jupiter.api.Test
    void add() {
        int actual = calculator.add(2, 2);
        Assertions.assertEquals(4, actual);
    }

    @org.junit.jupiter.api.Test()
    void addWhenInputFirstParametersIsNull() {
        RuntimeException thrown = Assertions.assertThrows(
                RuntimeException.class,
                () -> calculator.add(null, 2.0)
        );

        Assertions.assertTrue(thrown.getMessage().contains("one of input parameters is null"));
    }

    @org.junit.jupiter.api.Test()
    void addWhenSecondInputParametersIsNull() {
        RuntimeException thrown = Assertions.assertThrows(
                RuntimeException.class,
                () -> calculator.add(2.0, null)
        );

        Assertions.assertTrue(thrown.getMessage().contains("one of input parameters is null"));
    }

    @org.junit.jupiter.api.Test()
    void addWhenInputParametersArePositive() {
        int actual = calculator.add(2.0, 2.0);
        Assertions.assertEquals(4, actual);
    }
}