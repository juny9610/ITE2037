
public class Homework1 {
	public static void main(String[] args) {
		// Self Test #1
		System.out.println("Self Test #1");
		System.out.println("-------------");
		String name = "lim sung jun";
		
		String lastName = name.substring(0,3);
		String firstName = name.substring(3);
		
		lastName = lastName.replace("l", "L");
		
		firstName = firstName.trim();
		System.out.println("성: " + lastName);
		System.out.println("이름: " + firstName);
		
		// Self Test #2
		System.out.println("\nSelf Test #2");
		System.out.println("-------------");
		String fileName = "Hello.java";
		
		int index = fileName.indexOf('.');
		String str1 = fileName.substring(0, index);
		String str2 = fileName.substring(index+1);
		
		System.out.println("파일명: " + str1);
		System.out.println("확장자: " + str2);
	}
}
