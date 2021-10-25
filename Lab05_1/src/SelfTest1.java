
public class SelfTest1 {
	public static void main(String[] args) {
		Clock clock = new Clock();
		Time time = new Time();
		
		time.setTime(clock);
		System.out.println(clock.getClock());
		
		time.setTime(clock, "뻑꾹! 현재시간은 ");
		System.out.println(clock.getClock());
		
		clock.alarmmsg = "졸리다. 배고프다. 집 가고싶다.";
		System.out.println(clock.getClock());
	}
}
