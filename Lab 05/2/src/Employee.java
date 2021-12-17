
public class Employee {
	public static int empCount; //not an instance variable
	
	private String name;
	private int age;
	private String position;
	private int salary;
	private int vacationDays;
	
	public Employee(String name, int age, String position, int salary) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.vacationDays = 20;
		
		empCount++; //increment the number of employees
	}
	
	public Employee(String name, int age, String position, int salary, int vacationDays) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.vacationDays = vacationDays;
		
		empCount++;
	}
	
	public void getEmployee() {
		System.out.println("My Name is: " + this.name);
		System.out.println("My Age is: " + this.age);
		System.out.println("My Position is: " + this.position);
		System.out.println("My Salary is: " + this.salary);
		System.out.println("My vacation days: " + this.vacationDays);
		System.out.println();
	}
	

}
