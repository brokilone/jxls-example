package com.moex.jxlsexample.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Эмитент ПАО "Русская аквакультура"
 * Тип, вид ФА
 * Государственынй рег номер 1-01-04461-D
 * ISIN RU000A0JQTS3
 * Код ЦБ AQUA
 * Валюта торгов RUB
 * Режим торгов РПС
 * Размер стандартного лота 1
 * Величина шага цены 0,5
 * Количество знаков после запятой 1
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Circulation {
  private String issuer;
  private String type;
  private String regNumber;
  private String ISIN;
  private String code;
  private Currency currency;
  private TradingMode tradingMode;
  private Integer lotSize;
  private Double priceStep;
  private Integer accuracy;
}
