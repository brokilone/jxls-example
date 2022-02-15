package com.moex.jxlsexample.service.processor;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Processor<T> {
  File processOrder(List<T> entities) throws IOException;
}
