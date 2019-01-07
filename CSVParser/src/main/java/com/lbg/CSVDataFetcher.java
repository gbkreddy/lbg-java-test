package com.lbg;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lbg.exception.ConversionException;
import com.lbg.exception.ParseException;

/**
 * This class is responsible for fetching the data from csv file as per
 * specified type
 */
public class CSVDataFetcher {

	/**
	 * Returns the string value from the CSV file at specified line and element
	 * index
	 *
	 * @param filePath     String
	 * @param lineIndex    int
	 * @param elementIndex int
	 * @return String
	 */
	public String getStringValue(String filePath, int lineIndex, int elementIndex) {
		return fetchRawValue(filePath, lineIndex, elementIndex);
	}

	/**
	 * Returns the int value from the CSV file at specified line and element index
	 *
	 * @param filePath     String
	 * @param lineIndex    int
	 * @param elementIndex int
	 * @return int
	 */
	public int getIntValue(String filePath, int lineIndex, int elementIndex) {
		try {
			String rawValue = fetchRawValue(filePath, lineIndex, elementIndex);
			return Integer.parseInt(rawValue);
		} catch (NumberFormatException exp) {
			throw new ConversionException(exp);
		}
	}

	/**
	 * Returns the double value from the CSV file at specified line and element
	 * index
	 *
	 * @param filePath     String
	 * @param lineIndex    int
	 * @param elementIndex int
	 * @return double
	 */
	public double getDoubleValue(String filePath, int lineIndex, int elementIndex) {
		try {
			String rawValue = fetchRawValue(filePath, lineIndex, elementIndex);
			return Double.parseDouble(rawValue);
		} catch (NumberFormatException exp) {
			throw new ConversionException(exp);
		}
	}

	/**
	 * Returns the date value from the CSV file at specified line and element index
	 *
	 * @param filePath     String
	 * @param lineIndex    int
	 * @param elementIndex int
	 * @return Date
	 */
	public Date getDateValue(String filePath, int lineIndex, int elementIndex) {
		try {
			String rawValue = fetchRawValue(filePath, lineIndex, elementIndex);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MMM-dd");
			return format.parse(rawValue);
		} catch (java.text.ParseException exp) {
			throw new ConversionException(exp);
		}
	}

	/**
	 * Fethes the raw value from the file at specified line and element index
	 *
	 * @param filePath     String
	 * @param lineIndex    int
	 * @param elementIndex int
	 * @return String
	 */
	protected String fetchRawValue(String filePath, int lineIndex, int elementIndex) {
		try {
			return new CSVParser().findColumnValue(filePath, lineIndex, elementIndex);
		} catch (IOException exp) {
			throw new ParseException(exp);
		}
	}
}
