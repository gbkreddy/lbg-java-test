package com.lbg;

import java.io.FileReader;
import java.io.IOException;

/**
 * This class represents the CSV file parser. This parser doesn't use any
 * language specific tokenizers.
 */
public class CSVParser {
	/**
	 * Finds the column value at given line and column index
	 *
	 * @param filePath    String
	 * @param lineIndex   int
	 * @param columnIndex int
	 * @return String the raw value
	 * @throws IOException
	 */
	public String findColumnValue(String filePath, int lineIndex, int columnIndex) throws IOException {
		FileReader reader = new FileReader(filePath);
		int chValue;
		char ch;
		int lineCount = 0;
		int columnCount = 0;
		StringBuilder bldr = new StringBuilder();
		while ((chValue = reader.read()) != -1) {
			ch = (char) chValue;
			if (ch == '\n') {
				// New Line
				columnCount = 0;
				lineCount++;
			} else if (ch == ',') {
				// New Column
				columnCount++;
			} else if (lineIndex == lineCount && columnIndex == columnCount) {
				// Capture text on required line and column
				bldr.append(ch);
			} else if ((lineIndex == lineCount && columnCount == columnIndex + 1) || lineCount == lineIndex + 1) {
				// Break if column index or line index is exceeded
				break;
			}
		}
		reader.close();
		System.out.println(bldr.toString().trim());
		return bldr.toString().trim();
	}
}
