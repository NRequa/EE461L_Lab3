import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PhiladelphiaTest {

	@Test
	void testIsItSunny() {
		assertTrue(Philadelphia.isItSunny());
	}
	
	@Test
	void testAssertionFailure() {
		assertFalse(Philadelphia.isItSunny());
	}
	
	@Test
	void testAssertNotNull() {
		assertNotNull(Philadelphia.isItSunny());
	}
	
	@Test
	void testExceptionThrow() {
		int[] badArray = new int[1];
		int nullPter = badArray[2];
	}

}
