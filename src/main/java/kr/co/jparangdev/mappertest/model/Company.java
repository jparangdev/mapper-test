package kr.co.jparangdev.mappertest.model;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.jmapper.annotations.JGlobalMap;

import kr.co.jparangdev.mappertest.entity.CompanyEntity;
import kr.co.jparangdev.mappertest.entity.DepartmentEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JGlobalMap
public class Company {
	private String bizNo;
	private String companyName;
	private List<Department> departments;

	public CompanyEntity toEntity() {
		CompanyEntity entity = new CompanyEntity();
    	entity.setBizNo(this.bizNo);
    	entity.setCompanyName(this.companyName);
    	List<DepartmentEntity> departmentEntities = new ArrayList<>();
    	for (Department department : this.departments) {
    		departmentEntities.add(department.toEntity());
    	}
    	entity.setDepartments(departmentEntities);
    	return entity;
	}


}
