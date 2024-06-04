package com.example.demo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SampleTest {

    @BeforeAll
    static void setupSpec() {
        System.out.println("Initialization that is performed only once in the entire test class.");
    }

    @BeforeEach
    void setup() {
        System.out.println("Initialization before each test method is executed.");
        System.out.println("Preparation for object creation, data initialization, etc. (given is an alias of setup)");
        System.out.println("given must be used in the setup method.");
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleanup after each test method is executed.");
    }

    @AfterAll
    static void cleanupSpec() {
        System.out.println("A cleanup that is performed only once in the entire test class.");
    }

    @Test
    @Order(1)
    void someTestMethod() {
        System.out.println("Preparation for object creation, data initialization, etc.");
        System.out.println("Some initialization");

        System.out.println("Execute test objectives");
        System.out.println("certain conditions");

        System.out.println("Verify the result after when is executed");
        System.out.println("Checking the number of mock method calls, etc.");

        System.out.println("Simultaneous execution of test objectives and validation results");
        System.out.println("Some expected results");

        System.out.println("Post-processing work such as deleting data created during testing");
        System.out.println("Post-processing (if any)");
    }

    @Test
    @Order(2)
    void onePlusOneShouldEqualTwo() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(3)
    void shouldBeAbleToRemoveElementsFromList() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
        list.remove(0);
        assertEquals(List.of(2, 3, 4), list);
    }

    @Test
    @Order(4)
    void shouldGetIndexOutOfBoundsExceptionWhenRemovingNonExistentElement() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(20));
        assertEquals(4, list.size());
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForSquareCalculation")
    @Order(5)
    void calculateTheSquareOfANumber(int a, int b, int c) {
        assertEquals(c, Math.pow(a, b));
    }

    private static List<Arguments> provideNumbersForSquareCalculation() {
        return List.of(
                Arguments.of(1, 2, 1),
                Arguments.of(2, 2, 4),
                Arguments.of(3, 2, 9)
        );
    }
}
