package com.sda.testing.solution.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void shouldThrowArithmeticException() {
		assertThrows(ArithmeticException.class,  () -> Calculator.divide(3, 0));
	}
}