import java.util.Scanner;
import java.util.StringTokenizer;

class Student {
	private String name;
	private String major;
	private String number;
	private String birth;
	private String phone;
	private String ID;
	private String PW;
	
	private Scanner sc;
	private StringTokenizer st;
	
	public Student(String name, String major, String number, String birth, String phone) {
		this.phone = phone;
		setStudent(name, major, number, birth);
		this.sc = new Scanner(System.in);
	}
	
	public Student(String name, String major, String number, String birth) {
		this.phone = "010-0000-0000";
		setStudent(name, major, number, birth);
		this.sc = new Scanner(System.in);
	}
	
	public void setStudent(String name, String major, String number, String birth) {
		this.name = name;
		this.major = major;
		this.number = number;
		this.birth = birth;
		this.ID = number;
		this.PW = birth;
		st = new StringTokenizer(phone,"-");
		st.nextToken();
		while(st.hasMoreTokens())
			this.PW += st.nextToken();
	}
	
	public void studentInformation() {
		System.out.println("===============학생 정보===============");
		System.out.println("이름 :\t\t" + name);
		System.out.println("학과 :\t\t" + major);
		System.out.println("학번 :\t\t" + number);
		System.out.println("생년월일 :\t\t" + birth);
		System.out.println("핸드폰 :\t\t" + phone);
		System.out.println("ID :\t\t" + ID);
		System.out.println("Password :\t" + PW);
	}
	
	public void changeID() {
		System.out.println("=====================================");
		System.out.println("ID 변경");
		
		System.out.print("이름 : ");
		String input_name = sc.nextLine();
		System.out.print("학번 : ");
		String input_number = sc.nextLine();
		System.out.print("생년월일 : ");
		String input_birth = sc.nextLine();
		
		while(!input_name.equals(name) || !input_number.equals(number) || !input_birth.equals(birth)) {
			System.out.println("일치하는 정보가 없습니다.");
			
			System.out.println("=====================================");
			System.out.println("ID 변경");
			
			System.out.print("이름 : ");
			input_name = sc.nextLine();
			System.out.print("학번 : ");
			input_number = sc.nextLine();
			System.out.print("생년월일 : ");
			input_birth = sc.nextLine();
		}
		
		System.out.println("새로운 ID를 입력하세요 : ");
		String newID = sc.nextLine();
		this.ID = newID;
		System.out.println("ID 변경이 성공적으로 완료되었습니다.");
		this.studentInformation();
		return;
	}
	
	public void changePassword() {
		System.out.println("=====================================");
		System.out.println("Password 변경");
		
		System.out.print("ID : ");
		String input_ID = sc.nextLine();
		
		while(!input_ID.equals(ID)) {
			System.out.println("일치하는 정보가 없습니다.");
			
			System.out.println("=====================================");
			System.out.println("Password 변경");
			
			System.out.print("ID : ");
			input_ID = sc.nextLine();
		}
		
		System.out.print("기존 Password : ");
		String input_PW = sc.nextLine();
		
		while(!input_PW.equals(PW)) {
			System.out.println("Password가 일치하지 않습니다.");
			
			System.out.print("기존 Password : ");
			input_PW = sc.nextLine();
		}
		
		System.out.print("새로운 Password를 입력하세요 : ");
		String newPW = sc.nextLine();
		this.PW = newPW;
		System.out.println("Password 변경이 성공적으로 완료되었습니다.");
		this.studentInformation();	
	}
	
	public void login() {
		System.out.println("=====================================");
		System.out.println("로그인");
		
		System.out.print("ID : ");
		String input_ID = sc.nextLine();
		System.out.print("Password : ");
		String input_PW = sc.nextLine();
		
		while(!input_ID.equals(ID) || !input_PW.equals(PW)) {
			System.out.println("일치하는 정보가 없습니다.");
			this.login();
		}
		
		System.out.println(name + "님 환영합니다.");
		System.out.println("=====================================");
	}
	
	
}