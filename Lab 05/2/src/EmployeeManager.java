
public class EmployeeManager {
	public static void main(String[] args) {
		
		Employee emp1 = new Employee("James Wright", 42, "Manager", 20000);
		Employee emp2 = new Employee("Amy Smith", 27, "Design Coordinator", 8000, 15);
		Employee emp3 = new Employee("Peter Coolidge", 32, "Assitant Manager", 12000, 7);
		Employee emp4 = new Employee("John Doe", 22, "Engineer", 10000, 10);
		
		//System.out.println(emp1.toString() + emp2 + emp3 + emp4);
		emp1.getEmployee();
		emp2.getEmployee();
		emp3.getEmployee();
		emp4.getEmployee();
		
		System.out.println("Number of Employees: " + Employee.empCount + "\n");
	}
}
