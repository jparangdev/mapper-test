package kr.co.jparangdev.mappertest;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {

	public static void main(String[] args) throws Exception {
		Options options = new OptionsBuilder()
			.include(MapperBenchmark.class.getSimpleName())
			.forks(1)
			.warmupForks(1)
			.build();

		new Runner(options).run();
	}
}
