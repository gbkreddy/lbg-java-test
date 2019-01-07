package com.lbg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lbg.exception.EmptyValueException;
import com.lbg.exception.InvalidNumberException;

/**
 * Test class for {@link NumberToWordConverter}
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class NumberToWordConverterTest {

	/**
	 * Test int value
	 */
	@Test
	public void convertTest() throws EmptyValueException, InvalidNumberException {
		NumberToWordConverter.convert("10");
		NumberToWordConverter.convert("-10");
		NumberToWordConverter.convert("569457812");
		NumberToWordConverter.convert("0");
	}

	/**
	 * Test invalid int value
	 */
	@Test(expected = InvalidNumberException.class)
	public void invalidNumberTest() throws EmptyValueException, InvalidNumberException {
		NumberToWordConverter.convert("56945781222");
		NumberToWordConverter.convert("1*)");
		NumberToWordConverter.convert("");
	}

	/**
	 * Test empty value
	 */
	@Test(expected = EmptyValueException.class)
	public void emptyValueTest() throws EmptyValueException, InvalidNumberException {
		NumberToWordConverter.convert(null);
	}

}
