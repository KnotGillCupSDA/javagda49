package com.sda.testing.solution.conversion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

class MeasurementConverterTest {

	private MeasurementConverter measurementConverter;

	@BeforeEach
	void setUp() {
		measurementConverter = new MeasurementConverter();
	}

	@ParameterizedTest
	@EnumSource(value = ConversionType.class, names = { "YARDS_TO_METERS", "METERS_TO_YARDS" })
	void test(ConversionType conversionType) {
	}

	@ParameterizedTest
	@EnumSource
	void shouldAlwaysConvertToDoubleWithinBoundaries(ConversionType conversionType) {
		double convert = measurementConverter.convert(1032342, conversionType);

		assertTrue(convert < Double.MAX_VALUE);
		assertTrue(convert > Double.MIN_VALUE);
		assertNotEquals(Double.NaN, convert);
	}

	@ParameterizedTest
	@EnumSource(names = { "METERS_TO_YARDS", "INCHES_TO_CENTIMETERS", "MILES_TO_KILOMETERS" })
	public void shouldConvertToHigherValue(ConversionType conversionType) {
		int i = 100;
		double converted = measurementConverter.convert(i, conversionType);
		assertTrue(converted > i);
	}

	@ParameterizedTest
	@MethodSource
	void someOperationsShouldBeReversible(ConversionType c1, ConversionType c2) {
		double initialValue = 12345;
		assertEquals(initialValue,
				measurementConverter.convert(measurementConverter.convert(initialValue, c1), c2));
	}

	public static Stream<Arguments> someOperationsShouldBeReversible() {
		return Stream.of(
				Arguments.of(ConversionType.METERS_TO_YARDS, ConversionType.YARDS_TO_METERS),
				Arguments.of(ConversionType.YARDS_TO_METERS, ConversionType.METERS_TO_YARDS),
				Arguments.of(ConversionType.CENTIMETERS_TO_INCHES, ConversionType.INCHES_TO_CENTIMETERS),
				Arguments.of(ConversionType.INCHES_TO_CENTIMETERS, ConversionType.CENTIMETERS_TO_INCHES),
				Arguments.of(ConversionType.KILOMETERS_TO_MILES, ConversionType.MILES_TO_KILOMETERS),
				Arguments.of(ConversionType.MILES_TO_KILOMETERS, ConversionType.KILOMETERS_TO_MILES)
		);
	}
}