import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Homework2 {
	public static void main(String[] args) throws Exception {
		/*
		// Self Test #1
		int data = 0;
		System.out.println("저장할 내용을 입력하세요. 지금 입력한 내용은 파일에 저장됩니다.");
		
		try {
			File file = new File("output.txt");
			FileOutputStream fos = new FileOutputStream(file);
			while((data = System.in.read()) != -1) {
				fos.write(data);
			}
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		/*
		// Self Test #2
		String str;
		int count = 0, sum = 0, max = -1, min = 99999;
		InputStream in = System.in;
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(reader);
		System.out.println("숫자를 입력하시오.");
		while (true) {
			str = br.readLine();
			if(str.equals("입력 끝")) break;
			int num = Integer.parseInt(str);
			count++;
			sum += num;
			if(max < num) max = num;
			if(min > num) min = num;
		}
		
		System.out.println("1)합 2)평균 3)최대값 4)최소값 5)all");
		InputStream is = System.in;
		char inputChar = (char)is.read();
		
		switch(inputChar) {
		case '1':
			System.out.println("숫자의 합은" + sum + "입니다.");
			break;
		case '2':
			System.out.println("숫자의 평균은" + (int)sum/count + "입니다.");
			break;
		case '3':
			System.out.println("숫자의 최대값은" + max + "입니다.");
			break;
		case '4':
			System.out.println("숫자의 최소값은" + min + "입니다.");
			break;
		case '5':
			System.out.println("숫자의 합은" + sum + "입니다.");
			System.out.println("숫자의 평균은" + (int)sum/count + "입니다.");
			System.out.println("숫자의 최대값은" + max + "입니다.");
			System.out.println("숫자의 최소값은" + min + "입니다.");
			break;
		}
		*/
		//*
		// Self Test #3
		Scanner fileIn = null;
		String str;
		int number;

		try {
			fileIn = new Scanner (new FileInputStream("test2.txt"));
			FileOutputStream fos = new FileOutputStream("output2.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			while(fileIn.hasNextInt() || fileIn.hasNextLine()) {
				if(fileIn.hasNextInt()) {
					number = fileIn.nextInt();
					System.out.println(number*100);
					continue;
				}
				if(fileIn.hasNextLine()) {
					str = fileIn.nextLine();
					str = str.toUpperCase();
					osw.write(str + "\n");
				}
			}
			osw.close();
			fos.close();
			
			
		} catch(FileNotFoundException e) {
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//*/
	}
}
