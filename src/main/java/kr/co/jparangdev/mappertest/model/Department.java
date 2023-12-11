package kr.co.jparangdev.mappertest.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.jmapper.annotations.JGlobalMap;

import kr.co.jparangdev.mappertest.entity.DepartmentEntity;
import kr.co.jparangdev.mappertest.entity.EmployeeEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JGlobalMap
public class Department {
	private Integer departmentId;
	private String departmentName;
	private String managerName;
	private LocalDate creationDate;
	private Boolean active;
	private DepartmentType departmentType;
	private Double budget;
	private Long employeeCount;
	private List<Employee> employees;

	public enum DepartmentType {
		IT, HR, SALES, MARKETING
	}

	public DepartmentEntity toEntity() {
		DepartmentEntity entity = new DepartmentEntity();
    	entity.setDepartmentId(this.departmentId);
    	entity.setDepartmentName(this.departmentName);
    	entity.setManagerName(this.managerName);
    	entity.setCreationDate(this.creationDate);
    	entity.setActive(this.active);
    	entity.setDepartmentType(this.departmentType.name());
    	entity.setBudget(this.budget);
    	entity.setEmployeeCount(this.employeeCount);
    	List<EmployeeEntity> employeeEntities = new ArrayList<>();
    	for (Employee employee : this.employees) {
    		employeeEntities.add(employee.toEntity());
    	}
    	entity.setEmployees(employeeEntities);
    	return entity;
	}
}
