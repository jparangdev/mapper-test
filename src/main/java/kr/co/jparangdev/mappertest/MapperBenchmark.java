package kr.co.jparangdev.mappertest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.modelmapper.ModelMapper;
import org.openjdk.jmh.annotations.*;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import kr.co.jparangdev.mappertest.converter.CompanyMapstructMapper;
import kr.co.jparangdev.mappertest.entity.CompanyEntity;
import kr.co.jparangdev.mappertest.model.Company;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 1)
@State(Scope.Benchmark)
public class MapperBenchmark {

	private ModelMapper modelMapper;
	private CompanyMapstructMapper mapStructMapper;
	private Mapper dozerMapper;
	private List<Company> companies;

	@Setup
	public void setup() {
		modelMapper = new ModelMapper();
		mapStructMapper = CompanyMapstructMapper.INSTANCE;
		dozerMapper = DozerBeanMapperBuilder.buildDefault();
		companies = CompanyTestUtils.createTestCompanies(10000);
	}

	@Benchmark
	public void testNormal() {
		companies.forEach(Company::toEntity);
	}

	@Benchmark
	public void testModelMapper() {
		companies.forEach(c -> modelMapper.map(c, CompanyEntity.class));
	}

	@Benchmark
	public void testMapStruct() {
		companies.forEach(c ->  mapStructMapper.convert(c));
	}

	@Benchmark
	public void testDozer() {
		companies.forEach(c -> dozerMapper.map(c, CompanyEntity.class));
	}
}
