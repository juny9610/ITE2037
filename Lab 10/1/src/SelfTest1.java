import java.util.Scanner;

class NegativeBalanceException extends RuntimeException {
	public NegativeBalanceException() {
		super("인출 실패! 잔고 부족");
	}
}

public class SelfTest1 {
	public static void main(String[] args) {
		int balance = 5000;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("현재 잔액 : " + balance);
		System.out.println("인출할 돈을 입력하시오 :");
		int withdraw = sc.nextInt();
		
		try {
			if(balance < withdraw) 
				throw new NegativeBalanceException();
			else {
				balance -= withdraw;
				System.out.println("인출 성공! 남은 잔액은 " + balance + " 입니다.");
			}
		}
		catch (NegativeBalanceException e) {
			System.out.println(e.toString());
		}
	}
}
