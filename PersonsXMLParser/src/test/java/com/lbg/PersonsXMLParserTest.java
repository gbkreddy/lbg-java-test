package com.lbg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.lbg.exception.InvalidXMLException;
import com.lbg.exception.XMLNotFoundException;

/**
 * Test class for {@link PersonsXMLParser}
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class PersonsXMLParserTest {
	/**
	 * Test valid xml
	 */
	@Test
	public void validXMLTest() throws XMLNotFoundException, InvalidXMLException {
		PersonsXMLParser.main(new String[] { "persons.xml" });
	}

	/**
	 * Test invalid xml
	 */
	@Test(expected = XMLNotFoundException.class)
	public void inValidXMLTest() throws XMLNotFoundException, InvalidXMLException {
		PersonsXMLParser.main(new String[] { "person.xml" });
	}

	/**
	 * Test xml not found
	 */
	@Test(expected = XMLNotFoundException.class)
	public void xmlNotFoundTest() throws XMLNotFoundException, InvalidXMLException {
		PersonsXMLParser.main(new String[] { "1.xml" });
	}

}
