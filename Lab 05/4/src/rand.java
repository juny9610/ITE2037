
public class rand {
	public static void main(String[] args) {
		// Print a random number between 0.0 and 1.0 단, 소수넷째자리까지
		System.out.printf("Random number of between 0.0 and 1.0: %.4f%n", Math.random());
		System.out.println("Random number of between 0.0 and 1.0: " + Math.round(Math.random()*10000)/10000.0);
		System.out.println("Random number of between 0.0 and 1.0: " + String.format("%.4f", Math.random()));
		
		// Print a random number between 0 and 10
		System.out.printf("Random number of between 0 and 10: %d%n", (int)(Math.random()*10));
	}
}
