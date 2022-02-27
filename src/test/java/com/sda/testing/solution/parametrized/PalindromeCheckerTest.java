package com.sda.testing.solution.parametrized;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PalindromeCheckerTest {

	@ParameterizedTest
	@CsvSource({"sedes, true","kajak, true", "costam, false", "kobyla ma maly bok, true", "Kamil Ślimak, true"})
	void shouldCheckWhetherStringIsAPalindrome(String text, boolean expected) {
		//when
		boolean actual = PalindromeChecker.isPalindrome(text);

		//then
		assertEquals(expected, actual);
	}

}