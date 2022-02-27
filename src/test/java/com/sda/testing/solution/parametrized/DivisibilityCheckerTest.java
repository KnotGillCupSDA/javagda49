package com.sda.testing.solution.parametrized;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DivisibilityCheckerTest {

	@ParameterizedTest(name = "run #{index} with [{arguments}]" )
	@ValueSource(ints = {0, 3, 9, 12, 15, -3, -6})
	void shouldBeDivisibleBy3(int number) {
		//when
		boolean actual = DivisibilityChecker.isDivisibleBy3(number);

		//then
		assertTrue(actual);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 37, -4, -8, -17})
	void shouldNotBeDivisibleBy3(int number) {
		//when
		boolean actual = DivisibilityChecker.isDivisibleBy3(number);

		//then
		assertFalse(actual);
	}

}