# Mapper Test Project
This project is designed for testing the performance of various mappers. 

## Mappers Used
**MapStruct**: A mapper library that automatically generates code for high-performance mappings.

**ObjectMapper**: Utilizes the Jackson library's ObjectMapper to map between JSON data and Java objects.

**ModelMapper**: A library for simple object mappings, supporting both automatic and explicit mappings.

**Dozer** : A powerful, yet simple, mapping framework that is bi-directional and exceptionally convenient for complex data, offering extensive support for various APIs, features, and types

~~Orika~~ : (Java 17 is not supported) ~~Orika is a Java Bean mapping framework that can do automatic mappings, type conversion, and has support for mutable and immutable complex data types. It's lightning fast and is among the quickest mapping libraries.~~

~~JMapper~~ : (Java 17 is not supported) ~~a powerful, yet simple, mapping framework that is bi-directional and exceptionally convenient for complex data, offering extensive support for various APIs, features, and types~~

## Testing Approach
1. **Unit Testing**: We will write specific unit tests for each mapper to validate the correctness of the mappings. These will be included in their respective MapperTest.class files under src/test/java/<mapper_package>.
2. **BenchMark**: We will use JMH (Java Microbenchmark Harness) which is the gold standard for implementing benchmarks in Java. Each mapper will have a benchmarker class under the src/main/java/<mapper_package> to take advantage of granular control over the execution environment. This benchmarker will help us record performance of each mapper library.
