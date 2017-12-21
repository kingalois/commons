package test.java.at.am.common.logging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;

import at.am.common.logging.LogFactory;

public class LogFactoryTest {

	@Test
	public void testMakeLogger() {
		Logger logger = LogFactory.makeLogger();
		assertTrue(getClass().getName().contains("LogFactoryTest"));
		assertEquals(getClass().getName(), logger.getName());
	}
	
	
	@Test
	public void testMakeLoggerWithName() {
		Logger logger = LogFactory.makeLogger(getClass().getName());
		assertTrue(getClass().getName().contains("LogFactoryTest"));
		assertEquals(getClass().getName(), logger.getName());
	}

}
