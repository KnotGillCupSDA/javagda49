package com.sda.testing.solution.parametrized.romannumeral;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

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


	@ParameterizedTest
	@MethodSource("com.sda.testing.solution.parametrized.romannumeral.Outer#arabicToRomanTestData")
	public void shouldCalculateRomanValueForComplexNumberMethodSource(int arabic, String expected) {
		String roman = RomanNumeralConverter.romanFor(arabic);
		assertEquals(expected, roman);
	}

	public static Stream<Arguments> arabicToRomanTestData() {
		return Stream.of(
				Arguments.of(4999, "MMMMCMXCIX"),
				Arguments.of(3462, "MMMCDLXII")
		);
	}
}