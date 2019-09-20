import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeParserFullStatementTest {
	@Test
	void testNoColons() {
		String wrongFormat = "124355AM";
		NumberFormatException e = assertThrows(NumberFormatException.class, ()->{
			TimeParser.parseTimeToSeconds(wrongFormat);});
		}	
	@Test
	void testOneColon() {
		String wrongFormat = "12:4355AM";
		NumberFormatException e = assertThrows(NumberFormatException.class, ()->{
			TimeParser.parseTimeToSeconds(wrongFormat);});
		}
	@Test
	void testOutOfTimeRange() {
		String invalidInput = "25:43:55AM";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->{
			TimeParser.parseTimeToSeconds(invalidInput);});
		}
	@Test
	void testInPM() {
		String inPMInput = "9:43:22PM";
		int actualOut = TimeParser.parseTimeToSeconds(inPMInput);
		assertEquals(78202, actualOut);
	}
	@Test
	void testInAM() {
		String inAMInput = "12:43:22AM";
		int actualOut = TimeParser.parseTimeToSeconds(inAMInput);
		assertEquals(2602, actualOut);
	}
}
