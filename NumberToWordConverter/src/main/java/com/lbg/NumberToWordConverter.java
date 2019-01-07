package com.lbg;

import java.util.Scanner;

import org.slf4j.LoggerFactory;

import com.lbg.exception.EmptyValueException;
import com.lbg.exception.InvalidNumberException;

/**
 * This class represents the Number to word converter.
 */
public class NumberToWordConverter {

	private static final String[] specialUnits = { "", " thousand", " million", " billion", " trillion", " quadrillion",
			" quintillion" };

	private static final String[] tensUnits = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };

	private static final String[] numUnits = { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	/**
	 * converts LessThanOneThousand
	 * 
	 * @param number int
	 * @return String the raw value
	 */

	private static String convertLessThanOneThousand(int number) {
		String current;

		if (number % 100 < 20) {
			current = numUnits[number % 100];
			number /= 100;
		} else {
			current = numUnits[number % 10];
			number /= 10;

			current = tensUnits[number % 10] + current;
			number /= 10;
		}
		if (number == 0)
			return current;
		return numUnits[number] + " hundred" + current;
	}

	/**
	 * converts the given value
	 * 
	 * @param value String
	 * @return String value
	 * @throws EmptyValueException
	 * @throws InvalidNumberException
	 */
	public static String convert(String value) throws EmptyValueException, InvalidNumberException {
		int number;
		if (null == value || "".equals(value)) {
			LoggerFactory.getLogger(NumberToWordConverter.class).error("Entered value is empty");
			throw new EmptyValueException("Entered value is empty");
		} else {
			try {
				number = Integer.parseInt(value);
			} catch (NumberFormatException e) {
				LoggerFactory.getLogger(NumberToWordConverter.class).error("Entered value is invalid");
				throw new InvalidNumberException("Entered value is invalid");
			} finally {

			}
		}

		if (number == 0) {
			return "zero";
		}

		String prefix = "";

		if (number < 0) {
			number = -number;
			prefix = "negative";
		}

		String current = "";
		int place = 0;

		do {
			int n = number % 1000;
			if (n != 0) {
				String s = convertLessThanOneThousand(n);
				current = s + specialUnits[place] + current;
			}
			place++;
			number /= 1000;
		} while (number > 0);

		return (prefix + current).trim();
	}

	public static void main(String[] args) throws EmptyValueException, InvalidNumberException {
		String n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number to convert into word format : ");
		n = s.next();
		System.out.println(NumberToWordConverter.convert(n));
		s.close();
	}
}