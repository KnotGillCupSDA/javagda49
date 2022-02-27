package com.sda.testing.solution.parametrized.romannumeral;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RomanNumeralConverterTest {

	@Test
	void shouldUseRomanValuesFromEnum() {
		String roman = RomanNumeralConverter.romanFor(
				RomanNumeralConverter.ArabicToRoman.ONE.getArabic());

		assertEquals(RomanNumeralConverter.ArabicToRoman.ONE.getRoman(),
				roman);
	}
}