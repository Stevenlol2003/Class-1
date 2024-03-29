import java.util.Random;
import java.util.ArrayList;

public class GradeAnalyzer {
	/**
	 * This method first generates a random number between 0 and 100 (both inclusive),
	 * and then append this generated number at the end of the ArrayList grades.
	 * 
	 * Note: If either of the parameters is null, just return.
	 * 
	 * @param grades the ArrayList of all students' grades
	 * @param rand a random generator to generate grades
	 */
	public static void addGrade(ArrayList<Integer> grades, Random rand) {
		if (grades == null) {
			return;
		}
		else if (rand == null) {
			return;
		}

		grades.add(rand.nextInt(101));
	}
	
	/**
	 * This method searches for the lowest score in the ArrayList.
	 * Hint: Assume maximum score of 100 as initial minimum value
	 * 
	 * @param grades the ArrayList of scores to be searched from
	 * @return the minimum element in the ArrayList; -1 if it is null;
	 *         or 0 if the ArrayList is empty.
	 */
	public static int findMinScore(ArrayList<Integer> grades) {
		if (grades == null) {
			return -1;
		}
		else if (grades.isEmpty()) {
			return 0;
		}
		int min = 100;
		for (int i = 0; i < grades.size(); ++i) {
			if (grades.get(i) < min) {
				min = grades.get(i);
			}
		}
		return min;
	}
	
	/**
	 * This method calculates an average over all the scores in the ArrayList.
	 * 
	 * Note: The return value should include decimals.
	 * Make sure to use double division instead of integer division.
	 * 
	 * @param grades the ArrayList of all scores
	 * @return the average over all the elements in the ArrayList;
	 *         -1 if the ArrayList is null or empty;
	 */
	public static double calcAverageScore(ArrayList<Integer> grades) {
		if (grades == null) {
			return -1;
		}
		else if (grades.isEmpty()) {
			return -1;
		}
		double avg = 0;
		for (int i = 0; i < grades.size(); ++i) {
			avg += grades.get(i);
		}
		avg = avg / grades.size();
		return avg;
	}
	
	/**
	 * This method calculates the percentage of students whose grades are lesser than or equal to
	 * a certain threshold. E.g.:
	 *     if grades = [1, 2, 3, 4, 5]
	 *     and threshold = 4
	 *     the return value should be 80.0 (because 1, 2, 3, 4, are below threshold; 4 / 5 = 80%)
	 * 
	 * Note: The return value should include decimals.
	 * Make sure to use double division instead of integer division.
	 * 
	 * @param grades the ArrayList of all students' grades
	 * @param threshold  a specific number to compare with
	 * @return a percentage in the range of [0.0, 100.0]; or -1 if the ArrayList is null or empty.
	 */
	public static double calcPercentageBelow(ArrayList<Integer> grades, int threshold) {
		if (grades == null) {
			return -1;
		}
		else if (grades.isEmpty()) {
			return -1;
		}
		int counter = 0;
		for (int i = 0; i < grades.size(); ++i) {
			if (grades.get(i) <= threshold) {
				counter++;
			}
		}
		double percentage = (double) counter / grades.size() * 100;
		return percentage;
	}
	
	/**
	 * This method finds out all the students in the ArrayList with a certain grade,
	 * and stores their indices from that list into a new ArrayList, which is then returned.
	 * 
	 * @param grades the ArrayList of all students' grades
	 * @param gradeToFind a specific grade to be found in the ArrayList
	 * @return an ArrayList of found indices in ascending order; or null if grades is null
	 */
	public static ArrayList<Integer> findStudentsWithGrade(ArrayList<Integer> grades, int gradeToFind) {
		if (grades == null) {
			return null;
		}
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < grades.size(); ++i) {
			if (grades.get(i) == gradeToFind) {
				indices.add(i);
			}
		}
		return indices;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> grades = new ArrayList<Integer>();
		Random rand = new Random(Config.SEED);
		for (int i = 0; i < Config.NUM_STUDENTS; i++)
			addGrade(grades, rand);

		int maxScore = findMinScore(grades);
		System.out.println("The lowest score in this class is: " + maxScore);
		
		double aveScore = calcAverageScore(grades);
		System.out.println("The average score in this class is: " + aveScore);
		
		double failingRate = calcPercentageBelow(grades, 60);
		System.out.println("The percentage of students below 60 is: " + failingRate + "%");
		
		ArrayList<Integer> studentIndices = findStudentsWithGrade(grades, 100);
		System.out.println("Here are the IDs of students who got full marks: " + studentIndices);

	}

}
