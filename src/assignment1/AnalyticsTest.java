//DO NOT MODIFY THIS FILE

package assignment1;

import java.io.FileNotFoundException;
import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.text.*;
import java.util.*;
import org.junit.rules.*;
import java.lang.reflect.*;

public class AnalyticsTest {
	private Analytics diagnostic2018, diagnostic2019, diagnostic2020;
	public static String currentMethodName = null;
	public static int score = 0;
	public static String result = "";

	@Before
	public void beforeEachTest() throws FileNotFoundException {
		currentMethodName = null;
		diagnostic2018 = new Analytics("diagnostic_2018.csv");
		diagnostic2019 = new Analytics("diagnostic_2019.csv");
		diagnostic2020 = new Analytics("diagnostic_2020.csv");
	}

	@Test 
	public void testCountQuestions() {
		assertEquals(2, diagnostic2018.countQuestions());
		assertEquals(32, diagnostic2019.countQuestions());
		assertEquals(31, diagnostic2020.countQuestions());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test 
	public void testQuizTotal() {
		assertEquals(41, diagnostic2019.quizTotal());
		assertEquals(40, diagnostic2020.quizTotal());	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test 
	public void testGetQuestionWeight() {
		assertEquals(3, diagnostic2018.getQuestionWeight(1));
		assertEquals(3, diagnostic2018.getQuestionWeight(1));
		assertEquals(5, diagnostic2019.getQuestionWeight(1));
		assertEquals(2, diagnostic2019.getQuestionWeight(2));
		assertEquals(1, diagnostic2019.getQuestionWeight(20));
		assertEquals(1, diagnostic2019.getQuestionWeight(32));
		assertEquals(0, diagnostic2019.getQuestionWeight(0));
		assertEquals(0, diagnostic2019.getQuestionWeight(33));
		assertEquals(5, diagnostic2020.getQuestionWeight(1));
		assertEquals(2, diagnostic2020.getQuestionWeight(2));
		assertEquals(1, diagnostic2020.getQuestionWeight(18));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test 
	public void testCountPasses() {
		assertEquals(586, diagnostic2019.countPasses(0));
		assertEquals(27, diagnostic2019.countPasses(41));
		assertEquals(314, diagnostic2020.countPasses(0));
		assertEquals(14, diagnostic2020.countPasses(40));
		assertEquals(517, diagnostic2019.countPasses(20));
		assertEquals(264, diagnostic2020.countPasses(20));		
		assertEquals(470, diagnostic2019.countPasses(25));
		assertEquals(228, diagnostic2020.countPasses(25));		
		assertEquals(389, diagnostic2019.countPasses(30));
		assertEquals(177, diagnostic2020.countPasses(30));		
		assertEquals(220, diagnostic2019.countPasses(35));
		assertEquals(98, diagnostic2020.countPasses(35));		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test 
	public void testAvgQuizPercent() {
		assertEquals(74.5858, diagnostic2019.avgQuizPercent(), 0.001);
		assertEquals(71.8073, diagnostic2020.avgQuizPercent(), 0.001);	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test 
	public void testHighestMark() {
		assertEquals(41, diagnostic2019.highestMark());
		assertEquals(40, diagnostic2020.highestMark());	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test 
	public void testBestMarkByStudent() {
		assertEquals(41, diagnostic2019.bestMarkByStudent(2281102));
		assertEquals(0, diagnostic2019.bestMarkByStudent(1234567));
		assertEquals(27, diagnostic2019.bestMarkByStudent(2270809));
		assertEquals(30, diagnostic2019.bestMarkByStudent(2124406));
		assertEquals(33, diagnostic2020.bestMarkByStudent(602961));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test 
	public void testAvgMarkByStudentId() {
		assertEquals(35.6666, diagnostic2019.avgMarkByStudentId(2281102), 0.001);
		assertEquals(0, diagnostic2019.avgMarkByStudentId(1234567), 0.001);
		assertEquals(27, diagnostic2019.avgMarkByStudentId(2270809), 0.001);
		assertEquals(14.25, diagnostic2019.avgMarkByStudentId(2124406), 0.001);
		assertEquals(24.75, diagnostic2020.avgMarkByStudentId(602961), 0.001);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test 
	public void testAvgPercentByQuestion() {
		assertEquals(47.133, diagnostic2018.avgPercentByQuestion(1), 0.001);
		assertEquals(0, diagnostic2018.avgPercentByQuestion(2), 0.001);
		assertEquals(88.082, diagnostic2019.avgPercentByQuestion(1), 0.001);
		assertEquals(93.881, diagnostic2019.avgPercentByQuestion(2), 0.001);
		assertEquals(90.366, diagnostic2019.avgPercentByQuestion(3), 0.001);
		assertEquals(92.819, diagnostic2019.avgPercentByQuestion(4), 0.001);
		assertEquals(60.869, diagnostic2019.avgPercentByQuestion(31), 0.001);
		assertEquals(60.869, diagnostic2019.avgPercentByQuestion(32), 0.001);
		assertEquals(89.805, diagnostic2020.avgPercentByQuestion(1), 0.001);
		assertEquals(93.521, diagnostic2020.avgPercentByQuestion(2), 0.001);
		assertEquals(92.0, diagnostic2020.avgPercentByQuestion(3), 0.001);
		assertEquals(93.399, diagnostic2020.avgPercentByQuestion(4), 0.001);
		assertEquals(0, diagnostic2019.avgPercentByQuestion(0), 0.001);
		assertEquals(0, diagnostic2020.avgPercentByQuestion(0), 0.001);
		assertEquals(0, diagnostic2019.avgPercentByQuestion(35), 0.001);
		assertEquals(0, diagnostic2020.avgPercentByQuestion(40), 0.001);
		assertEquals(0, diagnostic2019.avgPercentByQuestion(-2), 0.001);
		assertEquals(0, diagnostic2020.avgPercentByQuestion(-3), 0.001);
		assertEquals(60.869, diagnostic2019.avgPercentByQuestion(31), 0.001);
		assertEquals(64.609, diagnostic2020.avgPercentByQuestion(30), 0.001);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test 
	public void testHardestQuestion() {
		assertEquals(2, diagnostic2018.hardestQuestion());
		assertEquals(28, diagnostic2019.hardestQuestion());
		assertEquals(22, diagnostic2020.hardestQuestion());	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test 
	public void testGetStudentAttempts() {
		assertEquals("[26, 40, 41]", Arrays.toString(diagnostic2019.getStudentAttempts(2281102)));
		assertEquals("[]", Arrays.toString(diagnostic2019.getStudentAttempts(1234567)));
		assertEquals("[27]", Arrays.toString(diagnostic2019.getStudentAttempts(2270809)));
		assertEquals("[2, 8, 17, 30]", Arrays.toString(diagnostic2019.getStudentAttempts(2124406)));
		assertEquals("[14, 24, 28, 33]", Arrays.toString(diagnostic2020.getStudentAttempts(602961)));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test 
	public void testGetHardestToEasiest() {
		assertEquals("[2, 1]", Arrays.toString(diagnostic2018.getHardestToEasiest()));
		assertEquals("[28, 27, 29, 22, 30, 9, 31, 32, 24, 14, 12, 26, 21, 13, 11, 20, 19, 10, 25, 17, 23, 18, 1, 16, 3, 5, 4, 7, 2, 8, 15, 6]", Arrays.toString(diagnostic2019.getHardestToEasiest()));
		assertEquals("[22, 28, 27, 29, 9, 31, 30, 12, 26, 21, 14, 11, 24, 19, 13, 17, 10, 20, 25, 23, 16, 18, 5, 1, 7, 3, 8, 6, 4, 2, 15]", Arrays.toString(diagnostic2020.getHardestToEasiest()));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test 
	public void testTimeToDisplayByIndex() {
		assertEquals("59 minutes", diagnostic2019.timeToDisplayByIndex(0));
		assertEquals("38 minutes", diagnostic2019.timeToDisplayByIndex(1));
		assertEquals("1 hour and 5 minutes", diagnostic2019.timeToDisplayByIndex(40));
		assertEquals("5 days, 18 hours and 29 minutes", diagnostic2019.timeToDisplayByIndex(10));
		assertEquals("1 hour", diagnostic2019.timeToDisplayByIndex(2));
		assertEquals("3 hours", diagnostic2019.timeToDisplayByIndex(3));
		assertEquals("18 days, 14 hours and 54 minutes", diagnostic2020.timeToDisplayByIndex(10));
		assertEquals("2 days and 3 hours", diagnostic2020.timeToDisplayByIndex(14));
		assertEquals("1 day", diagnostic2020.timeToDisplayByIndex(23));
		assertEquals("9 days", diagnostic2020.timeToDisplayByIndex(27));
		assertEquals("0 minutes", diagnostic2020.timeToDisplayByIndex(53));
		assertEquals("1 minute", diagnostic2020.timeToDisplayByIndex(4));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

}
