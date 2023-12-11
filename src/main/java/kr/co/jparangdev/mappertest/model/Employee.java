package kr.co.jparangdev.mappertest.model;

import java.time.LocalDate;

import com.googlecode.jmapper.annotations.JGlobalMap;
import com.googlecode.jmapper.annotations.JMapConversion;

import kr.co.jparangdev.mappertest.entity.EmployeeEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JGlobalMap
public class Employee {
	private Long employeeId;
	private String employeeName;
	private String jobTitle;
	private LocalDate hireDate;
	private Double salary;
	private EmployeeType employeeType;

	public enum EmployeeType {
		FULL_TIME, PART_TIME, CONTRACTOR, INTERN
	}

	public EmployeeEntity toEntity() {
		EmployeeEntity entity = new EmployeeEntity();
    	entity.setEmployeeId(this.employeeId);
    	entity.setEmployeeName(this.employeeName);
    	entity.setJobTitle(this.jobTitle);
    	entity.setHireDate(this.hireDate);
    	entity.setSalary(this.salary);
    	entity.setEmployeeType(this.employeeType.name());
    	return entity;
	}

	@JMapConversion(from={"employeeType"}, to={"employeeType"})
	public String conversion(EmployeeType employeeType){
		return employeeType.name();
	}
}
