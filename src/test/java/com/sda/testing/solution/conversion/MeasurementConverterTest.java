package com.sda.testing.solution.conversion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

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


	@ParameterizedTest
	@MethodSource
	void someOperationsShouldBeReversible(ConversionType c1, ConversionType c2) {
		int initialValue = 4234;

		MeasurementConverter measurementConverter = new MeasurementConverter();
		double converted1 = measurementConverter.convert(initialValue, c1);
		double converted2 = measurementConverter.convert(converted1, c2);

		assertEquals(initialValue, converted2);
	}
}