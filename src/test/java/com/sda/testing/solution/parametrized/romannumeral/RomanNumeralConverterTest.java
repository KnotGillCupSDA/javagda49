package com.sda.testing.solution.parametrized.romannumeral;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class RomanNumeralConverterTest {

	@ParameterizedTest
	@EnumSource
	void shouldUseRomanValuesFromEnum(RomanNumeralConverter.ArabicToRoman arabicToRoman) {
		String roman = RomanNumeralConverter.romanFor(arabicToRoman.getArabic());
		assertEquals(arabicToRoman.getRoman(), roman);
	}

	@ParameterizedTest
	@CsvSource({"4999, MMMMCMXCIX", "3462, MMMCDLXII","538, DXXXVIII" })
	public void shouldCalculateRomanValueForComplexNumber(int arabic, String expected) {
		String roman = RomanNumeralConverter.romanFor(arabic);
		assertEquals(expected, roman);
	}
}