package kr.co.jparangdev.mappertest.entity;

import java.util.List;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JGlobalMap
public class CompanyEntity {
	private String bizNo;
	private String companyName;
	private List<DepartmentEntity> departments;
}
