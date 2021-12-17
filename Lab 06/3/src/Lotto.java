import java.util.Random;

public class Lotto {
	public static void main(String[] args) {
		Random random = new Random();
		int[] lottoNumber = new int[6];
		for(int i = 0; i < lottoNumber.length; i++) {
			lottoNumber[i] = random.nextInt(45)+1;
			for(int j = 0; j < i; j++) {
				if(lottoNumber[i] == lottoNumber[j]) i--;
			}
		}
		
		int tmp;
		for(int i = lottoNumber.length; i > 0; i--) {
			for(int j = 0; j < i-1; j++) {
				if(lottoNumber[j] > lottoNumber[j+1]) {
					tmp = lottoNumber[j];
					lottoNumber[j] = lottoNumber[j+1];
					lottoNumber[j+1] = tmp;
				}
			}
		}
		
		System.out.println("로또6/45 당첨번호 정보");
		for(int i = 0; i < lottoNumber.length; i++) {
			System.out.print(lottoNumber[i] + " ");
		}
	}
}
