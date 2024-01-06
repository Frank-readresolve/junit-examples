package co.simplon.junitexamples; // same package name as source code but not in same Maven folder

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Test class for {@link Calculator} class. Describes scenarios for all the
 * methods.
 */
@DisplayName("Calculator tests")
class CalculatorTest {

    /**
     * A parameterized test method, describes a scenario for the
     * {@link Calculator#divide(double, double)} method.
     * <p>
     * Parameters are provided by the {@link #doubleProvider()} method.
     * 
     * @param a        value for the {@code divide}'s first parameter
     * @param b        value for the {@code divide}'s second parameter
     * @param expected assertion's expected value
     */
    @ParameterizedTest
    @MethodSource("doubleProvider")
    @DisplayName("Calculator.divide test cases")
    void shouldDivide(double a, double b, double expected) {
	double actual = Calculator.divide(a, b);
	assertEquals(expected, actual);
    }

    /**
     * Provides extreme (with min and max) and bounded (around 0.0) values, and
     * resulting operations' expected values to the {@code shouldDivide} test
     * scenario.
     * 
     * @return a stream of arguments for the {@code shouldDivide} method
     */
    static Stream<Arguments> doubleProvider() {
	return Stream.of(
		// NaN and Inf cases:
		Arguments.of(0.0, 0.0, Double.NaN),
		Arguments.of(-0.0, -0.0, Double.NaN),
		Arguments.of(-0.0, 0.0, Double.NaN),
		Arguments.of(0.0, -0.0, Double.NaN),
		Arguments.of(1.0, 0.0, Double.POSITIVE_INFINITY),
		Arguments.of(-1.0, 0.0, Double.NEGATIVE_INFINITY),
		Arguments.of(Double.MAX_VALUE, 0.0, Double.POSITIVE_INFINITY),
		Arguments.of(Double.MIN_VALUE, 0.0, Double.POSITIVE_INFINITY),
		Arguments.of(Double.MAX_VALUE, Double.MIN_VALUE,
			Double.POSITIVE_INFINITY),
		// "Normal result" cases:
		Arguments.of(0.0, 1.0, 0.0), Arguments.of(0.0, -1.0, -0.0),
		Arguments.of(-0.0, 1.0, -0.0), Arguments.of(-0.0, -1.0, 0.0),
		Arguments.of(1.0, 1.0, 1.0), Arguments.of(1.0, -1.0, -1.0),
		Arguments.of(-1.0, 1.0, -1.0), Arguments.of(-1.0, -1.0, 1.0),
		Arguments.of(Double.MAX_VALUE, Double.MAX_VALUE, 1.0),
		Arguments.of(Double.MIN_VALUE, Double.MAX_VALUE, 0.0),
		Arguments.of(Double.MIN_VALUE, Double.MIN_VALUE, 1.0));
    }

}
