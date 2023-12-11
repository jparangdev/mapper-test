package kr.co.jparangdev.mappertest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import kr.co.jparangdev.mappertest.converter.CompanyMapstructMapper;
import kr.co.jparangdev.mappertest.entity.CompanyEntity;
import kr.co.jparangdev.mappertest.model.*;

class MapperTest {

	@BeforeAll
	static void setMappers() {
	}

	@Test
	void testNormal() {
		Company company = CompanyTestUtils.createTestCompany();
		CompanyEntity entity = company.toEntity();

		assertCompany(company, entity);

	}

	@Test
	void testModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		Company company = CompanyTestUtils.createTestCompany();
		CompanyEntity entity = modelMapper.map(company, CompanyEntity.class);

		assertCompany(company, entity);
	}

	@Test
	void testMapStruct() {
		CompanyMapstructMapper mapper = CompanyMapstructMapper.INSTANCE;
		Company company = CompanyTestUtils.createTestCompany();
		CompanyEntity entity = mapper.convert(company);

		assertCompany(company, entity);
	}

	@Test
	void testDozer() {
		Mapper dozerMapper = DozerBeanMapperBuilder.buildDefault();
		Company company = CompanyTestUtils.createTestCompany();
		CompanyEntity entity = dozerMapper.map(company, CompanyEntity.class);

		assertCompany(company, entity);
	}


	private static void assertCompany(Company company, CompanyEntity entity) {
		assertThat(company).usingRecursiveComparison()
			.ignoringFieldsOfTypes(Department.DepartmentType.class, Employee.EmployeeType.class)
			.isEqualTo(entity);
	}

}
