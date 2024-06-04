package com.example.demo

import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification
import spock.lang.Unroll

@ActiveProfiles("test")
@Unroll
class SampleSpec extends Specification {

    def setupSpec() {
        println("Initialization executed once in the entire test class.")
    }

    def setup() {
        println("Initialization before each test method execution.")
        given:
        println("Preparation work such as object creation and data initialization. (given is an alias for setup)")
        println("given must be used in the setup method.")
    }

    def cleanup() {
        println("Cleanup work after each test method execution.")
    }

    def cleanupSpec() {
        println("Cleanup work executed once in the entire test class.")
    }

    def "some test method"() {
        // setup: or given:
        setup:
        println("Preparation work such as object creation and data initialization.")
        println("Some initialization")

        when:
        println("Execute test target")
        println("Some conditions")

        then:
        println("Verify the result after executing when")
        println("Check the number of times the mock method is called, etc.")

        expect:
        println("Execute the test target and verify the result simultaneously")
        println("Some expected results")

        cleanup:
        println("Post-processing work such as deleting data created during the test")
        println("Post-processing (if any)")
    }

    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }

    def "should be able to remove elements from the list"() {
        given:
        def list = [1, 2, 3, 4]

        when:
        list.remove(0)

        then:
        list == [2, 3, 4]
    }

    def "should get an index out of bounds exception when removing a non-existent element"() {
        given:
        def list = [1, 2, 3, 4]

        when:
        list.remove(20)

        then:
        thrown(IndexOutOfBoundsException)
        list.size() == 4
    }

    def "calculate the square of a number"(int a, int b, int c) {
        expect:
        Math.pow(a, b) == c

        where:
        a | b | c
        1 | 2 | 1
        2 | 2 | 4
        3 | 2 | 9
    }
}
