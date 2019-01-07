package com.lbg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Test class for {@link CSVParser}
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class CSVParserTest {
	/**
	 * Parser
	 */
	private CSVParser parser;

	/**
	 * Setup
	 */
	@Before
	public void setUp() {
		parser = new CSVParser();
	}

	/**
	 * Test findColumnValue when success
	 *
	 * @throws IOException
	 */
	@Test
	public void testFindColumnValue_whenSuccess() throws IOException {
		String value = parser.findColumnValue("src/test/resources/csv_file.csv", 2, 2);
		assertNotNull(value);
		assertEquals("Line3Column3", value);
	}

	/**
	 * Test findColumnValue when exception
	 *
	 * @throws IOException
	 */
	@Test(expected = IOException.class)
	public void testFindColumnValue_whenException() throws IOException {
		parser.findColumnValue("src/test/resources/csv_file1.csv", 2, 2);
	}
}
