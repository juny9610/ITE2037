
public class SelfTest1 {
	public static void main(String[] args) {
		int[] grades = {65, 70, 73, 75, 80, 85, 97};
		
		GradeBook gradeBook = new GradeBook(grades);
		gradeBook.displayMessage();
		gradeBook.displayBarChart();
	}
}
