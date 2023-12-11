package kr.co.jparangdev.mappertest.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import kr.co.jparangdev.mappertest.entity.*;
import kr.co.jparangdev.mappertest.model.*;

@Mapper
public interface CompanyMapstructMapper {

	CompanyMapstructMapper INSTANCE = Mappers.getMapper(CompanyMapstructMapper.class);

	CompanyEntity convert(Company company);

	DepartmentEntity convert(Department department);

	EmployeeEntity convert(Employee employee);
}
