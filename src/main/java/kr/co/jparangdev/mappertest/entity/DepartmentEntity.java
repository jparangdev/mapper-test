package kr.co.jparangdev.mappertest.entity;

import java.time.LocalDate;
import java.util.List;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JGlobalMap
public class DepartmentEntity {
	private Integer departmentId;
	private String departmentName;
	private String managerName;
	private LocalDate creationDate;
	private Boolean active;
	private String departmentType;
	private Double budget;
	private Long employeeCount;
	private List<EmployeeEntity> employees;
}
