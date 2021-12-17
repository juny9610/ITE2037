import java.util.InputMismatchException;
import java.util.Scanner;

public class SelfTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요. >> ");
		
		try {
			int num = sc.nextInt();
			if(num%2 ==  0) System.out.println("짝수");
			else System.out.println("홀수");
			sc.close();
		}
		catch(InputMismatchException e) {
			System.out.println("정수를 입력하지 않았습니다.");
		}
		finally {
			System.out.println("프로그램이종료됩니다.");
		}
	}

}
