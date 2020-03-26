package assignment1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnalyticsTest {
	private Analytics a1, a2;
	
	@BeforeEach
	void setup() throws FileNotFoundException {
		a1 = new Analytics("diagnostic_2019.csv");
		a2 = new Analytics("diagnostic_2020.csv");
	}
	
	@Test
	void testCountQuestions() {
		assertEquals(32, a1.countQuestions());
		assertEquals(31, a2.countQuestions());
	}

	@Test
	void testGetQuestionWeight() {
		assertEquals(5, a1.getQuestionWeight(1));
		assertEquals(2, a1.getQuestionWeight(2));
		assertEquals(1, a1.getQuestionWeight(20));
		assertEquals(1, a1.getQuestionWeight(32));
		assertEquals(0, a1.getQuestionWeight(0));
		assertEquals(0, a1.getQuestionWeight(33));
	}

	@Test
	void testQuizTotal() {
		assertEquals(41, a1.quizTotal());
		assertEquals(40, a2.quizTotal());	
	}
	
	@Test
	void testAverageQuizPercentageMark() {
		assertEquals(74.5858, a1.averageQuizPercentageMark(), 0.001);
		assertEquals(71.8073, a2.averageQuizPercentageMark(), 0.001);	
	}

	@Test
	void testHighestMark() {
		assertEquals(41, a1.highestMark());
		assertEquals(40, a2.highestMark());	
	}

	@Test
	void testCountPasses() {
		assertEquals(513, a1.countPasses(20));
		assertEquals(260, a2.countPasses(20));		
		assertEquals(452, a1.countPasses(25));
		assertEquals(223, a2.countPasses(25));		
		assertEquals(357, a1.countPasses(30));
		assertEquals(160, a2.countPasses(30));		
		assertEquals(189, a1.countPasses(35));
		assertEquals(78, a2.countPasses(35));		
	}

	@Test
	void testBestMarkByStudent() {
		assertEquals(41, a1.bestMarkByStudent(2281102));
		assertEquals(0, a1.bestMarkByStudent(1234567));
		assertEquals(27, a1.bestMarkByStudent(2270809));
		assertEquals(30, a1.bestMarkByStudent(2124406));
		assertEquals(33, a2.bestMarkByStudent(602961));
	}

	@Test
	void testAverageMarkByStudent() {
		assertEquals(35.6666, a1.averageMarkByStudent(2281102), 0.001);
		assertEquals(0, a1.averageMarkByStudent(1234567), 0.001);
		assertEquals(27, a1.averageMarkByStudent(2270809), 0.001);
		assertEquals(14.25, a1.averageMarkByStudent(2124406), 0.001);
		assertEquals(24.75, a2.averageMarkByStudent(602961), 0.001);
	}

	@Test
	void testAveragePercentageMarkByQuestion() {
		assertEquals(88.082, a1.averagePercentageMarkByQuestion(1), 0.001);
		assertEquals(93.881, a1.averagePercentageMarkByQuestion(2), 0.001);
		assertEquals(90.366, a1.averagePercentageMarkByQuestion(3), 0.001);
		assertEquals(92.819, a1.averagePercentageMarkByQuestion(4), 0.001);
		assertEquals(60.869, a1.averagePercentageMarkByQuestion(31), 0.001);
		assertEquals(60.869, a1.averagePercentageMarkByQuestion(32), 0.001);
		assertEquals(89.805, a2.averagePercentageMarkByQuestion(1), 0.001);
		assertEquals(93.521, a2.averagePercentageMarkByQuestion(2), 0.001);
		assertEquals(92.0, a2.averagePercentageMarkByQuestion(3), 0.001);
		assertEquals(93.399, a2.averagePercentageMarkByQuestion(4), 0.001);
		assertEquals(0, a1.averagePercentageMarkByQuestion(0), 0.001);
		assertEquals(0, a2.averagePercentageMarkByQuestion(0), 0.001);
		assertEquals(60.869, a1.averagePercentageMarkByQuestion(31), 0.001);
		assertEquals(64.609, a2.averagePercentageMarkByQuestion(30), 0.001);
	}

	@Test
	void testHardestQuestion() {
		assertEquals(28, a1.hardestQuestion());
		assertEquals(22, a2.hardestQuestion());	
	}

	@Test
	void testGetAllAttemptsForStudent() {
		assertEquals("[26, 40, 41]", Arrays.toString(a1.getAllAttemptsForStudent(2281102)));
		assertEquals("[]", Arrays.toString(a1.getAllAttemptsForStudent(1234567)));
		assertEquals("[27]", Arrays.toString(a1.getAllAttemptsForStudent(2270809)));
		assertEquals("[2, 8, 17, 30]", Arrays.toString(a1.getAllAttemptsForStudent(2124406)));
		assertEquals("[14, 24, 28, 33]", Arrays.toString(a2.getAllAttemptsForStudent(602961)));
	}

	@Test
	void testGetHardestToEasiest() {
		assertEquals("[28, 27, 29, 22, 30, 9, 31, 32, 24, 14, 12, 26, 21, 13, 11, 20, 19, 10, 25, 17, 23, 18, 1, 16, 3, 5, 4, 7, 2, 8, 15, 6]", Arrays.toString(a1.getHardestToEasiest()));
		assertEquals("[22, 28, 27, 29, 9, 31, 30, 12, 26, 21, 14, 11, 24, 19, 13, 17, 10, 20, 25, 23, 16, 18, 5, 1, 7, 3, 8, 6, 4, 2, 15]", Arrays.toString(a2.getHardestToEasiest()));
	}

	@Test
	void testGetTimeTakenAsStringByIndex() {
		assertEquals("59 minutes", a1.getTimeTakenAsStringByIndex(0));
		assertEquals("38 minutes", a1.getTimeTakenAsStringByIndex(1));
		assertEquals("1 hour and 5 minutes", a1.getTimeTakenAsStringByIndex(40));
		assertEquals("5 days, 18 hours and 29 minutes", a1.getTimeTakenAsStringByIndex(10));
		assertEquals("18 days, 14 hours and 54 minutes", a2.getTimeTakenAsStringByIndex(10));
		assertEquals("2 days and 3 hours", a2.getTimeTakenAsStringByIndex(14));
		assertEquals("1 day", a2.getTimeTakenAsStringByIndex(23));
		assertEquals("9 days", a2.getTimeTakenAsStringByIndex(27));
		assertEquals("0 minutes", a2.getTimeTakenAsStringByIndex(53));
	}
}
