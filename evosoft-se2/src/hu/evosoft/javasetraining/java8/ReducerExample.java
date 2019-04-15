package hu.evosoft.javasetraining.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReducerExample {

	public static class Employee {
		private String lastName;
		private String firstName;
		private String empId;
		private int age;
		private int salary;

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getEmpId() {
			return empId;
		}

		public void setEmpId(String empId) {
			this.empId = empId;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}
	}

	// /Stub method to create list of employee objects
	private static List createList() {
		List<ReducerExample.Employee> empList = new ArrayList<>();
		Employee emp = new Employee();
		emp.setEmpId("E001");
		emp.setAge(40);
		emp.setFirstName("John");
		emp.setLastName("Smith");
		emp.setSalary(5000);
		empList.add(emp);
		emp = new Employee();
		emp.setEmpId("E002");
		emp.setAge(35);
		emp.setFirstName("Don");
		emp.setLastName("Johnson");
		emp.setSalary(7000);
		empList.add(emp);
		emp = new Employee();
		emp.setEmpId("E003");
		emp.setAge(24);
		emp.setFirstName("Luke");
		emp.setLastName("Skywalker");
		emp.setSalary(9000);
		empList.add(emp);
		return empList;
	}

	public static void main(String[] args) {
		
		@SuppressWarnings("unchecked")
		List<ReducerExample.Employee> empList = ReducerExample.createList();

		// Using reduce method which returns Optional object
		Optional<Employee> result = empList.stream().reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
		if (result.isPresent()) {
			System.out.println("Employee with max salary - " + result.get().getFirstName() + " salary "
					+ result.get().getSalary());
		}

		// Using reduce method with identity element
		Employee emp = empList.stream().reduce(new Employee(), (e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
		System.out.println("Employee with max salary - " + emp.getFirstName() + " salary " + emp.getSalary());
		
		int salarySum = empList.parallelStream().reduce(0, (sum, e) -> sum + e.getSalary(), Integer::sum);
		
		System.out.println("Sum of all salaries " + salarySum); 

	}
}
