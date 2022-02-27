package com.sda.testing.solution.parametrized.romannumeral;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class Outer {
	public static Stream<Arguments> arabicToRomanTestData() {
		return Stream.of(
				Arguments.of(4999, "MMMMCMXCIX"),
				Arguments.of(3462, "MMMCDLXII")
		);
	}
}
