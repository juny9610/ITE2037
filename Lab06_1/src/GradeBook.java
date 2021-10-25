
public class GradeBook {
	private int[] grades;
	
	public GradeBook(int[] arr) {
		this.grades = arr;
	}
	
	public void displayMessage() {
		int sum = 0;
		int max = -1;
		int min = 101;
		for(int i = 0; i < this.grades.length; i++) {
			sum += this.grades[i];
			if(max < this.grades[i]) max = this.grades[i];
			if(min > this.grades[i]) min = this.grades[i];
		}
		System.out.println("Class average : " +	String.format("%.2f", (float)sum/this.grades.length));
		System.out.println("Highest grade : " + max);
		System.out.println("Lowest grade : " + min);
		System.out.println();
	}
	
	public void displayBarChart() {
		int[] counts = new int[11];
		for(int i = 0; i < this.grades.length; i++) {
			if(this.grades[i] < 10) counts[0]++;
			else if(this.grades[i] < 20) counts[1]++;
			else if(this.grades[i] < 30) counts[2]++;
			else if(this.grades[i] < 40) counts[3]++;
			else if(this.grades[i] < 50) counts[4]++;
			else if(this.grades[i] < 60) counts[5]++;
			else if(this.grades[i] < 70) counts[6]++;
			else if(this.grades[i] < 80) counts[7]++;
			else if(this.grades[i] < 90) counts[8]++;
			else if(this.grades[i] < 100) counts[9]++;
			else counts[10]++;
		}
		System.out.println("Bar Chart");
		System.out.print("00-09 : ");
		for(int i = 0; i < counts[0]; i++)
			System.out.print("*");
		System.out.println();
		
		System.out.print("10-19 : ");
		for(int i = 0; i < counts[1]; i++)
			System.out.print("*");
		System.out.println();
		
		System.out.print("20-29 : ");
		for(int i = 0; i < counts[2]; i++)
			System.out.print("*");
		System.out.println();
		
		System.out.print("30-39 : ");
		for(int i = 0; i < counts[3]; i++)
			System.out.print("*");
		System.out.println();
		
		System.out.print("40-49 : ");
		for(int i = 0; i < counts[4]; i++)
			System.out.print("*");
		System.out.println();
		
		System.out.print("50-59 : ");
		for(int i = 0; i < counts[5]; i++)
			System.out.print("*");
		System.out.println();
		
		System.out.print("60-69 : ");
		for(int i = 0; i < counts[6]; i++)
			System.out.print("*");
		System.out.println();
		
		System.out.print("70-79 : ");
		for(int i = 0; i < counts[7]; i++)
			System.out.print("*");
		System.out.println();
		
		System.out.print("80-89 : ");
		for(int i = 0; i < counts[8]; i++)
			System.out.print("*");
		System.out.println();
		
		System.out.print("90-99 : ");
		for(int i = 0; i < counts[9]; i++)
			System.out.print("*");
		System.out.println();
		
		System.out.print("  100 : ");
		for(int i = 0; i < counts[10]; i++)
			System.out.print("*");
		System.out.println();
	}
}