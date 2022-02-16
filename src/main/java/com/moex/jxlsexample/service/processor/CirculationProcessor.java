package com.moex.jxlsexample.service.processor;

import com.moex.jxlsexample.model.Circulation;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;

@Service
public class CirculationProcessor implements Processor<Circulation> {
  private final Random random = new Random();


  @Override
  public File processOrder(List<Circulation> circulations) throws IOException {
    var byteArrayOutputStream = new ByteArrayOutputStream();

    try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("template.xls")) {
      Context context = new Context();
      context.putVar("circulations", circulations);
      JxlsHelper.getInstance().processTemplate(is, byteArrayOutputStream, context);
    }
    String fileName = "output" + random.nextInt() + ".xls";
    return Files.write(Path.of("src", "main", "resources", fileName), byteArrayOutputStream.toByteArray(), StandardOpenOption.CREATE_NEW).toFile();

  }
}
