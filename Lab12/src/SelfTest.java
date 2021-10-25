
public class SelfTest {
	public static void main(String[] args) {
		NumberGenerator num = new RandomNumberGenerator();
		Observer ob1 = new DigitObserver();
		Observer ob2 = new GraphObserver();
		
		num.addObserver(ob1);
		num.addObserver(ob2);
		num.execute();
	}

}
