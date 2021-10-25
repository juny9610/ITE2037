
public class MathDemo {
	public static void main(String[] args) {
		
		// get two integer numbers
		int x = 60984;
		int y = 1000;
		
		// print the larger number between x and y
		System.out.println("Math.max(" + x + "," + y + ")=" + Math.max(x,y));
		
		// print the smaller number between x and y
		System.out.println("Math.min(" + x + "," + y + ")=" + Math.min(x,y));
		
		// print x raised by y and then y raised by x
		System.out.println("Math.pow(" + x + "," + y + ")=" + Math.pow(x,y));
		System.out.println("Math.pow(" + y + "," + x + ")=" + Math.pow(y,x));
		
		// print the square root of x
		System.out.println("Math.sqrt(" + x + ")=" + Math.sqrt(x));

	}
}
