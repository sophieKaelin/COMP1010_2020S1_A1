package assignment1;

import java.io.FileNotFoundException;

public class Analytics {
	public String[] records;
	public int[] weights;

	public Analytics(String filename) throws FileNotFoundException {
		records = DataReader.readData(filename);
		weights = DataReader.getWeights(filename);
		System.out.println(this.averageQuizPercentageMark());
		for(int i=0; i < records.length; i++) {
			System.out.println(getTimeTakenAsStringByIndex(i));
		}
	}

	/**
	 * 5 marks
	 * @return the number of questions on the quiz
	 */
	public int countQuestions() {
		return weights.length;
	}

	/**
	 * 5 marks
	 * @return the total marks for the quiz
	 */
	public int quizTotal() {
		int total = 0;
		for(int i = 0; i < weights.length; i++) {
			total += weights[i];
		}
		return total;
	}

		public int[] getAttempt(int idx) {
			String[] tokens = records[idx].split(",");
			int[] result = new int[weights.length];
			for(int i=4; i < tokens.length; i++) {
				result[i-4] = Integer.parseInt(tokens[i]);
			}
			return result;
		}

	/**
	 * 10 marks
	 * @param questionNumber
	 * @return the weight of the given question number.
	 * return 0 if questionNumber is not valid.
	 * for example, any value OUTSIDE 1 to 31 is invalid if there are 31 questions.
	 */
	public int getQuestionWeight(int questionNumber) {
		if(questionNumber <= 0 || questionNumber >= countQuestions())	{
			return 0;
		}
		System.out.println("             " + weights[1]);
		return weights[questionNumber-1];
	}

	/**
	 * 10 marks
	 * @param passMark
	 * @return number of students who pass the quiz with the passing mark provided as the parameter
	 */
	public int countPasses(int passMark) {
		int count = 0;

		return count;
	}

	/**
	 * 10 marks
	 * @return the overall average percentage marks for the quiz. 
	 * @note the mark for a given attempt is the 4th value in the record
	 */
	public double averageQuizPercentageMark() {
		int total = 0;

		return 0;
	}

	/**
	 * 10 marks
	 * @return the highest mark for the quiz
	 */
	public int highestMark() {
		int highest = 0;

		return highest;
	}

	/**
	 * 10 marks
	 * @param id
	 * @return the best mark for the student with given id 
	 * (return 0 if an attempt for that id doesn't exist)
	 */
	public  int bestMarkByStudent(int id) {
		int best = 0;

		return best;
	}

	/**
	 * 10 marks
	 * @param id
	 * @return the average mark for the student with given id 
	 * (return 0 if an attempt for that id doesn't exist)
	 */
	public double averageMarkByStudent(int id) {
		return 0;
	}

	/**
	 * 5 marks
	 * @param questionNumber
	 * @return the average percentage mark for the given question number.
	 * if questionNumber = 1, return the average percentage mark for the first question, and so on...
	 */
	public double averagePercentageMarkByQuestion(int questionNumber) {
		return 0;
	}

	/**
	 * 10 marks
	 * @return the number of the hardest question (based on average mark).
	 * return 1 if the first question was the hardest, 2 if the second was and so on...
	 */
	public int hardestQuestion() {
		int toughest = 1;

		return toughest;
	}

	/**
	 * HELPER
	 * @param data
	 * @param item
	 * @return
	 */
	private static boolean contains(int[] data, int item) {

		return false;
	}

	/**
	 * 5 marks
	 * @param id
	 * @return an array containing marks of all attempts for student with given id
	 * return an empty array if an attempt for student with given id doesn't exist.
	 */
	public int[] getAllAttemptsForStudent(int id) {

		return null;
	}

	/**
	 * 5 marks
	 * 
	 * @return an array containing question numbers from the hardest to easiest (based on average marks in the questions)
	 */
	public int[] getHardestToEasiest() {
		return null;
	}

	/**
	 * 5 marks
	 * @param time (in minutes)
	 * 
	 * return time in the formats specified in the JUnit tests
	 */
	public String getTimeTakenAsStringByIndex(int idx) {
		return "Hgjhg";		
	}

	/**
	 * HELPER
	 * 
	 * @param date
	 * @param time
	 * @return number of seconds since 00:00, 01/01/2020
	 */
	private static int epoch(String[] date, String[] time) {
		int total = 0;

		return total;
	}
}
