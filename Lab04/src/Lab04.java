
public class Lab04 {
	public static void main(String[] args) {
		Student sungjunLim = new Student("임성준", "Computer software", "2015004911", "961030", "010-5626-4599");
		sungjunLim.studentInformation();
		sungjunLim.changeID();
		sungjunLim.changePassword();
		sungjunLim.login();
		
		Student gildongHong = new Student("홍길동", "Korean language and literature", "16120001", "120101");
		gildongHong.studentInformation();
		gildongHong.changeID();
		gildongHong.changePassword();
		gildongHong.login();
	}
}

