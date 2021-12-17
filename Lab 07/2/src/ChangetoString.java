
public class ChangetoString {
	public static void main(String[] args) {
		Student1 s1 = new Student1();
		s1.name = "홍길동";
		s1.age = 20;
		
		Student2 s2 = new Student2();
		s2.name = "임꺽정";
		s2.age = 30;
		
		System.out.println(s1.toString());
		System.out.println("---------------------------");
		System.out.println(s2.toString());
	}
}

class Student1 {
	public String name;
	public int age;
	
	public void setStudent1(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Student2 {
	public String name;
	public int age;
	
	public void setStudent2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student2 [name=" + this.name + ", age=" + age + "]";
	}
}