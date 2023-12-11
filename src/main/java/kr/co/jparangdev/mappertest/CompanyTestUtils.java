package kr.co.jparangdev.mappertest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import kr.co.jparangdev.mappertest.model.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyTestUtils {

	public static List<Company> createTestCompanies(int quantity) {
		return IntStream.range(0, quantity)
			.mapToObj(i -> createTestCompany())
			.toList();
	}

	public static Company createTestCompany() {
		Company company = new Company();
		company.setCompanyName("Jparangdev");
		company.setBizNo(String.format("%.16f", Math.random()).substring(2, 18));

		Department itDepartment = createITDepartment();
		Department hrDepartment = createHRDepartment();

		company.setDepartments(Arrays.asList(itDepartment, hrDepartment));

		return company;
	}

	public static Department createITDepartment() {
		Department itDepartment = new Department();
		itDepartment.setDepartmentId(1);
		itDepartment.setDepartmentName("IT Department");
		itDepartment.setManagerName("John Doe");
		itDepartment.setCreationDate(LocalDate.now());
		itDepartment.setActive(true);
		itDepartment.setDepartmentType(Department.DepartmentType.IT);
		itDepartment.setBudget(1000000.0);
		itDepartment.setEmployeeCount(50L);

		Employee alice = createFullTimeEmployee("Alice", 80000);
		Employee bob = createPartTimeEmployee("Bob", 30, 25.0);
		itDepartment.setEmployees(Arrays.asList(alice, bob));

		return itDepartment;
	}

	public static Department createHRDepartment() {
		Department hrDepartment = new Department();
		hrDepartment.setDepartmentId(2);
		hrDepartment.setDepartmentName("HR Department");
		hrDepartment.setManagerName("Jane Doe");
		hrDepartment.setCreationDate(LocalDate.now());
		hrDepartment.setActive(true);
		hrDepartment.setDepartmentType(Department.DepartmentType.HR);
		hrDepartment.setBudget(500000.0);
		hrDepartment.setEmployeeCount(30L);

		Employee charlie = createContractorEmployee("Charlie", 40, 35.0);
		Employee david = createInternEmployee("David", 20, 15.0);
		hrDepartment.setEmployees(Arrays.asList(charlie, david));

		return hrDepartment;
	}

	public static Employee createFullTimeEmployee(String name, double salary) {
		Employee employee = new Employee();
		employee.setEmployeeId(1L);
		employee.setEmployeeName(name);
		employee.setJobTitle("Software Engineer");
		employee.setHireDate(LocalDate.now());
		employee.setSalary(salary);
		employee.setEmployeeType(Employee.EmployeeType.FULL_TIME);
		return employee;
	}

	public static Employee createPartTimeEmployee(String name, int hoursPerWeek, double hourlyRate) {
		Employee employee = new Employee();
		employee.setEmployeeId(2L);
		employee.setEmployeeName(name);
		employee.setJobTitle("Part-time Developer");
		employee.setHireDate(LocalDate.now());
		employee.setSalary(hoursPerWeek * hourlyRate);
		employee.setEmployeeType(Employee.EmployeeType.PART_TIME);
		return employee;
	}

	public static Employee createContractorEmployee(String name, int hoursPerWeek, double hourlyRate) {
		Employee employee = new Employee();
		employee.setEmployeeId(3L);
		employee.setEmployeeName(name);
		employee.setJobTitle("Contractor");
		employee.setHireDate(LocalDate.now());
		employee.setSalary(hoursPerWeek * hourlyRate);
		employee.setEmployeeType(Employee.EmployeeType.CONTRACTOR);
		return employee;
	}

	public static Employee createInternEmployee(String name, int hoursPerWeek, double hourlyRate) {
		Employee employee = new Employee();
		employee.setEmployeeId(4L);
		employee.setEmployeeName(name);
		employee.setJobTitle("Intern");
		employee.setHireDate(LocalDate.now());
		employee.setSalary(hoursPerWeek * hourlyRate);
		employee.setEmployeeType(Employee.EmployeeType.INTERN);
		return employee;
	}
}
