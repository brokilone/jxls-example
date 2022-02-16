package com.moex.jxlsexample.utils;

import com.moex.jxlsexample.model.Circulation;
import com.moex.jxlsexample.model.Currency;
import com.moex.jxlsexample.model.TradingMode;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.IntStream;

@UtilityClass
public final class TestUtils {

  public static List<Circulation> generateCirculations(Integer amount) {
    return IntStream.range(0, amount)
        .mapToObj(value -> generateCirculation()).toList();
  }

  public static Circulation generateCirculation() {
    return new Circulation()
        .setIssuer("ПАО «Русская Аквакультура»")
        .setType("АО")
        .setRegNumber("1-01-04461-D")
        .setISIN("RU000A0JQTS3")
        .setCode("AQUA")
        .setCurrency(Currency.RUB)
        .setTradingMode(TradingMode.LARGE_PACK)
        .setLotSize(1)
        .setPriceStep(0.5)
        .setAccuracy(1);
  }
}
