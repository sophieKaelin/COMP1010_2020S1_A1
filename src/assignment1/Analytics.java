package assignment1;

import java.io.FileNotFoundException;

public class Analytics {
	/**
	 * An array of strings for the students results combined
	 * to split it into usable data use:
	 * for an item in the array at index i,
	 * String[] tokens = records[i].split(",");
	 * - tokens[0] = Student ID (numerical value stored as String)
	 * - tokens[1] = Start Date and Time (format DD/MM/YYYY HH:MM)
	 * - tokens[2] = End Date and Time (format DD/MM/YYYY HH:MM)
	 * - tokens[3] = Total Grade (numerical value stored as String)
	 * @note marks for each question are stored as Strings in tokens[4], tokens[5], ....
	 * - marks in first question (numerical value stored as String, but could be "-" implying non-attempt): tokens[4]
	 * - marks in second question (numerical value stored as String, but could be "-" implying non-attempt): tokens[5]
	 * ...
	 */
	public String[] records;
	public int[] weights;

	public Analytics(String filename) throws FileNotFoundException {
		records = DataReader.readData(filename);
		weights = DataReader.getWeights(filename);
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
		for(int item : weights) {
			total += item;
		}
		return total;
	}

	/**
	 * 10 marks
	 * @param questionNumber
	 * @return the weight of the given question number.
	 * return 0 if questionNumber is not valid.
	 * for example, any value OUTSIDE 1 to 31 is invalid if there are 31 questions.
	 */
	public int getQuestionWeight(int questionNumber) {
		if(questionNumber <= 0 || questionNumber > countQuestions()) {
			return 0;
		}
		return weights[questionNumber-1];
	}
	
	/**
	 * DO NOT MODIFY
	 * PROVIDED AS A SAMPLE
	 * @return number of students who get a zero
	 */
	public int countZeroes() {
		int count = 0;
		for(int i=0; i < records.length; i++) {
			String[] tokens = records[i].split(",");
			if(Integer.parseInt(tokens[3]) == 0) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 10 marks
	 * @param passMark
	 * @return number of students who pass the quiz with the passing mark provided as the parameter
	 */
	public int countPasses(int passMark) {
		int count = 0;
		for(String record : records) {
			String[] tokens = record.split(",");
			if(Integer.parseInt(tokens[3]) >= passMark) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 10 marks
	 * @return the overall average percentage marks for the quiz. 
	 * @note the mark for a given attempt is the 4th value in the record
	 */
	public double avgQuizPercent() {
		double count = 0;
		for(String record: records) {
			String[] tokens = record.split(",");
			count += (Integer.parseInt(tokens[3]) / (double)quizTotal());
		}
		return count / records.length * 100; //to be completed
	}

	/**
	 * 10 marks
	 * @return the highest mark for the quiz
	 */
	public int highestMark() {
		int highest = 0;
		for(String record: records) {
			String[] tokens = record.split(",");
			highest = Math.max(highest, Integer.parseInt(tokens[3]));
		}
		return highest; //to be completed
	}

	/**
	 * 10 marks
	 * @param id
	 * @return the best mark for the student with given id 
	 * (return 0 if an attempt for that id doesn't exist)
	 */
	public int bestMarkByStudent(int id) {
		int best = 0;
		for(String record: records) {
			String[] tokens = record.split(",");
			String ID = String.valueOf(id);
			if(ID.equals(tokens[0])) {
				best = Math.max(best, Integer.parseInt(tokens[3]));
			}
		}
		return best; //to be completed
	}

	/**
	 * 10 marks
	 * @param id
	 * @return the average mark for the student with given id 
	 * (return 0 if an attempt for that id doesn't exist)
	 */
	public double avgMarkByStudentId(int id) {
		double average = 0;
		int count = 0;
		for(String record: records) {
			String[] tokens = record.split(",");
			String ID = String.valueOf(id);
			if(ID.equals(tokens[0])) {
				average += Integer.parseInt(tokens[3]);
				count++;
			}
		}
		if(count == 0) {
			return 0;
		}
		return average / (double)count; //to be completed
	}

	/**
	 * 5 marks
	 * @param questionNumber
	 * @return the average percentage mark for the given question number.
	 * if questionNumber = 1, return the average percentage mark for the first question, and so on...
	 * 
	 * NOTE: some students might not attempt a particular question, indicated by a dash ("-").
	 * these values don't contribute towards attempts or average. 
	 * For example, let the following be the first entries in the array records:
	 * 
	 * records[0] = "551102,14/2/18 10:52,14/2/18 11:00,2,1,1"
	 * records[1] = "595789,14/2/18 12:27,14/2/18 14:08,1,-,1"
	 * records[2] = "463521,14/2/18 13:26,17/2/18 16:32,1,-,0"
 	 * records[3] = "610197,14/2/18 17:04,14/2/18 17:31,0,0,0"
 	 * 
 	 * If you look at Question 1 (5th comma-separate value), the marks are: "1", "-", "-" and "0".
 	 * Thus the average should be, mathematically, (1+0)/2, which should be returned as (maintaining precision) 0.5
	 */
	public double avgPercentByQuestion(int questionNumber) {
		if(getQuestionWeight(questionNumber) == 0) {
			return 0;
		}
		int numStudents = 0;
		int marks = 0;
		
		for(String record:records) {
			String[] tokens = record.split(",");
			if(!tokens[questionNumber+3].equals("-")) {
				numStudents ++;
				marks += Integer.parseInt(tokens[questionNumber+3]);
			}
		}	
		return marks / (double)getQuestionWeight(questionNumber) * 100 / numStudents;
	}

	/**
	 * 10 marks
	 * @return the number of the hardest question (based on average mark).
	 * return 1 if the first question was the hardest, 2 if the second was and so on...
	 */
	public int hardestQuestion() {
		int num = 1;
		double curLowest = avgPercentByQuestion(1);
		for(int i = 1; i < weights.length; i++) {
			double thisLow = avgPercentByQuestion(i+1);
			if(thisLow < curLowest) {
				num = i+1;
				curLowest = thisLow;
			}
		}
		return num; //to be completed
	}

	/**
	 * 5 marks
	 * @param id
	 * @return an array containing marks of all attempts for student with given id
	 * return an empty array if an attempt for student with given id doesn't exist.
	 */
	public int[] getStudentAttempts(int id) {
		int attempts = numAttempts(id); 
		if(attempts == 0) {
			return new int[0];
		}
		int[] scores = new int[attempts];
		int idx = 0;
		for(String record: records) {
			String[] tokens = record.split(",");
			if(tokens[0].equals(String.valueOf(id))) {
				scores[idx] = Integer.parseInt(tokens[3]);
				idx++;
			}
		}
		return scores;
	}
	
	/* HELPER FUNCTION
	 * @param id
	 * @return number of attempts made by a student
	 */
	public int numAttempts(int id) {
		int attempts = 0;
		for(String record: records) {
			String[] tokens = record.split(",");
			if(tokens[0].contentEquals(String.valueOf(id))) {
				attempts++;
			}
		}
		return attempts;
	}

	/**
	 * 5 marks
	 * 
	 * @return an array containing question numbers from the hardest to easiest (based on average marks in the questions)
	 */
	public int[] getHardestToEasiest() {
		int[] questions = new int[countQuestions()];
		for(int i = 0; i < countQuestions(); i++) {
			questions[i] = i+1;
		}
		insertionSort(questions);
		return questions; //to be completed
	}
	
	/**
	 * HELPER METHOD
	 * Insertion Sort
	 */
	void insertionSort(int arr[]) { 
        for (int i = 1; i < arr.length; i++) { 
            int val = arr[i]; 
            int j = i - 1; 
 
            while (j >= 0 && avgPercentByQuestion(arr[j]) > avgPercentByQuestion(val)) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = val; 
        } 
    } 

	/**
	 * 5 marks
	 * @param idx index in array records for which the time must be returned
	 * @return time in the formats specified in the JUnit tests
	 * 
	 * there are three components in time (for our purpose) - days, hours and minutes.
	 * only those components must be included that have a non-zero value
	 * (the only exception being when the quiz starts and finishes during the same minute,
	 * in which case it should return "0 minutes").
	 * a comma separates two components, except the last two, where "and" is the separator.
	 * 
	 * see JUnit tests for more clarity
	 * 
	 */
	public String timeToDisplayByIndex(int idx) {
		String[] tokens = records[idx].split(",");

		String[] start = tokens[1].split("/|:| ");
		String[] end = tokens[2].split("/|:| ");
		
		int minute = Integer.parseInt(end[4]) - Integer.parseInt(start[4]);
		int hour = Integer.parseInt(end[3]) - Integer.parseInt(start[3]);
		int day = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
		int month = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
		int year = Integer.parseInt(end[2]) - Integer.parseInt(start[2]);
		
		if(minute < 0) {
			hour --;
		}
		if(hour < 0) {
			day --;
		}
		if(day < 0) {
			month --;
		}
		if(month < 0) {
			year --;
		}
		
		String minutes = createString(start[4], end[4], "minute");
		String hours = createString(start[3], end[3], "hour");
		String days = createString(start[0], end[0], "day");
		String months = createString(start[1], end[1], "month");
		String years = createString(start[2], end[2], "year");
		
		return years + months + days + hours + minutes; //to be completed
	}
	/*
	 * HELPER METHOD
	 * Purpose: check to see if there are multiple minutes/hours etc.
	 * @return string containing "minute" or "minutes"
	 */
	public String isMultiple(int x) {
		if(x == 1) {
			return "";
		}
		return "s";
	}
	
	/*
	 * HELPER METHOD
	 * @return the string for a given unit of time
	 */
	public String createString(String start, String end, String unit) {
		int time = Integer.parseInt(end) - Integer.parseInt(start);
		if(time == 0) {
			return "";
		}
		if(!unit.equals("minute")) {
			return (time + " " + unit + isMultiple(time));
		}
		return (time + " " + unit + isMultiple(time)) + ", ";
	}
}
