import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeParserFullPathTest {
	@Test
	void testNoColonsDeadEnd() {
		String wrongFormat = "124355AM";
		NumberFormatException e = assertThrows(NumberFormatException.class, ()->{
			TimeParser.parseTimeToSeconds(wrongFormat);});
		}	
	@Test
	void testOneColonDeadEnd() {
		String wrongFormat = "12:4355AM";
		NumberFormatException e = assertThrows(NumberFormatException.class, ()->{
			TimeParser.parseTimeToSeconds(wrongFormat);});
		}
	@Test
	void testAdd12InRange() {
		String inPMInput = "9:43:22PM";
		int actualOut = TimeParser.parseTimeToSeconds(inPMInput);
		assertEquals(78202, actualOut);
	}
	@Test
	void testAdd12OutRange() {
		String inPMInput = "26:43:22PM";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->{
			TimeParser.parseTimeToSeconds(inPMInput);});
		
	}
	@Test
	void testSet0InRange() {
		String inAMInput = "12:43:22AM";
		int actualOut = TimeParser.parseTimeToSeconds(inAMInput);
		assertEquals(2602, actualOut);	
	}
	@Test
	void testSet0OutRange() {
		String inAMInput = "12:43:99PM";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->{
			TimeParser.parseTimeToSeconds(inAMInput);});
	}
	@Test
	void testHoursUnchangedInRange() {
		String inAMInput = "9:43:22AM";
		int actualOut = TimeParser.parseTimeToSeconds(inAMInput);
		assertEquals(35002, actualOut);	
		
	}
	@Test
	void testHoursUnchangedOutRange() {
		String neitherInput = "26:43:22AM";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->{
			TimeParser.parseTimeToSeconds(neitherInput);});
	}
}
