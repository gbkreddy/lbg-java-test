package com.lbg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Test class for {@link CSVDataFetcher}
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class CSVDataFetcherTest {
	/**
	 * {@link CSVDataFetcher instance}
	 */
	private CSVDataFetcher csvDataFetcher;

	/**
	 * Setup
	 */
	@Before
	public void setUp() {
		csvDataFetcher = new CSVDataFetcher();
	}

	/**
	 * Test get string value
	 */
	@Test
	public void testGetStringValue() {
		String value = csvDataFetcher.getStringValue("src/test/resources/csv_file.csv", 1, 1);
		assertNotNull(value);
		assertEquals("Line2Column2", value);
	}

	/**
	 * Test get int value
	 */
	@Test
	public void testGetIntValue() {
		int value = csvDataFetcher.getIntValue("src/test/resources/csv_file.csv", 1, 3);
		assertEquals(5, value);
	}

	/**
	 * Test get double value
	 */
	@Test
	public void testGetDoubleValue() {
		double value = csvDataFetcher.getDoubleValue("src/test/resources/csv_file.csv", 1, 4);
		assertEquals(2.3d, value, 1e-7);
	}

	/**
	 * Test get date value
	 */
	@Test
	public void testGetDateValue() {
		Date date = csvDataFetcher.getDateValue("src/test/resources/csv_file.csv", 1, 5);
		assertNotNull(date);
		assertEquals(1526149800000l, date.getTime());
	}
}
