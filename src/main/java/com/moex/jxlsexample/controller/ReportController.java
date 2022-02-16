package com.moex.jxlsexample.controller;

import com.moex.jxlsexample.model.Circulation;
import com.moex.jxlsexample.service.processor.Processor;
import com.moex.jxlsexample.utils.TestUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class ReportController {
  private final Processor<Circulation> processor;
  private List<Circulation> circulations;

  @PostConstruct
  private void initList() {
    circulations = TestUtils.generateCirculations(10000);
  }


  @SneakyThrows
  @GetMapping
  public String generateReport() {
    var file = processor.processOrder(circulations);
    return "Order saved in: " + file.toPath();
  }
}
