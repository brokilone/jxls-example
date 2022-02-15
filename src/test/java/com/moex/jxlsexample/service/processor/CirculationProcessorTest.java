package com.moex.jxlsexample.service.processor;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.moex.jxlsexample.service.processor.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class CirculationProcessorTest {

  private CirculationProcessor circulationProcessor = new CirculationProcessor();

  @Test
  public void shouldGenerateOrderFromTemplate() throws IOException {
    var circulation = TestUtils.generateCirculation();
    var output = circulationProcessor.processOrder(List.of(circulation));

    assertNotNull(output);
    Files.delete(output.toPath());

  }

  @Test
  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void shouldGenerateOrdersFromTemplate() throws IOException {
    var circulations = TestUtils.generateCirculations(10000);
    var output = circulationProcessor.processOrder(circulations);

    assertNotNull(output);
//    Files.delete(output.toPath());
  }

  @Test
  public void runBenchmarks() throws Exception {
    Options options = new OptionsBuilder()
        .include(this.getClass().getName())
        .mode(Mode.AverageTime)
        .warmupTime(TimeValue.seconds(1))
        .warmupIterations(6)
        .threads(1)
        .measurementIterations(6)
        .forks(1)
        .shouldFailOnError(true)
        .shouldDoGC(true)
        .build();

    new Runner(options).run();
  }

}