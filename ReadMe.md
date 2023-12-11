# Mapper Test Project
This project is designed for testing the performance of various mappers. 

## Mappers Used
**MapStruct**: A mapper library that automatically generates code for high-performance mappings.

**ObjectMapper**: Utilizes Jackson library's ObjectMapper to map between JSON data and Java objects.

**ModelMapper**: A library for simple object mappings, supporting both automatic and explicit mappings.

**Dozer** : A powerful, yet simple, mapping framework that is bi-directional and exceptionally convenient for complex data, offering extensive support for various APIs, features, and types

## Testing Approach
Build and run the project to measure the performance of each mapper in various scenarios. The performance measurement results will be documented on the Results Page.

## How to Run
To build the project and execute performance tests, use the following commands:

Copy code
```bash
.gradlew clean build
java -jar build/libs/benchmarks.jar
```

Performance Test Results
Check the Performance Test Results Page for detailed performance measurements of each mapper.
