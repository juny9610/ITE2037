import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = new int[5];
		int cnt = 0;
		System.out.print("Input : ");
		while(cnt<5) {
			int num = scan.nextInt();
			array[cnt] = num;
			cnt++;
		}
		
		cnt = 0;
		int tmp;
		for(int i = array.length; i > 0; i--) {
			for(int j = 0; j < i-1; j++) {
				cnt++;
				if(array[j] > array[j+1]) {
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}
		}
		
		System.out.print("Output : ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		scan.close();
	}
}
