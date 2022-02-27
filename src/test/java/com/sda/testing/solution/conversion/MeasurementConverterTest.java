package com.sda.testing.solution.conversion;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class MeasurementConverterTest {

	@ParameterizedTest
	@EnumSource(value = ConversionType.class, names = {"YARDS_TO_METERS", "METERS_TO_YARDS"})
	void test(ConversionType conversionType) {
	}

	@ParameterizedTest
	@EnumSource
	void shouldAlwaysConvertToDoubleWithinBoundaries(ConversionType conversionType) {
		double convert = new MeasurementConverter().convert(1032342, conversionType);

		assertTrue(convert < Double.MAX_VALUE);
		assertTrue(convert > Double.MIN_VALUE);
		assertNotEquals(Double.NaN, convert);
	}

	@ParameterizedTest
	@EnumSource(names = {"METERS_TO_YARDS", "INCHES_TO_CENTIMETERS", "MILES_TO_KILOMETERS"})
	public void shouldConvertToHigherValue(ConversionType conversionType) {
		int i = 100;

		double converted = new MeasurementConverter().convert(i, conversionType);

		assertTrue(converted > i);
	}
}