
public class MainClass {
	public static void main(String[] args) {
		AddCalculator add = new AddCalculator(2, 3);
		SubCalculator sub = new SubCalculator(2, 3);
		
		add.show();
		sub.show();
	}
}

abstract class Calculator {
	int num1;
	int num2;
	
	abstract void operator();
}

class AddCalculator extends Calculator {
	int ans;
	
	public AddCalculator(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	void operator() {
		ans = num1 + num2;
	}
	
	void show() {
		operator();
		System.out.println(num1 + " + " + num2 + " = " + ans);
	}
}

class SubCalculator extends Calculator {
	int ans;
	
	public SubCalculator(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	void operator() {
		ans = num1 - num2;
	}
	
	void show() {
		operator();
		System.out.println(num1 + " - " + num2 + " = " + ans);
	}
}