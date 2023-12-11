package kr.co.jparangdev.mappertest.entity;

import java.time.LocalDate;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JGlobalMap
public class EmployeeEntity {
	private Long employeeId;
	private String employeeName;
	private String jobTitle;
	private LocalDate hireDate;
	private Double salary;
	private String employeeType;
}
