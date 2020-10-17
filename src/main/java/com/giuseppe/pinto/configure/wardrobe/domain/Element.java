package com.giuseppe.pinto.configure.wardrobe.domain;

import java.math.BigDecimal;
import java.util.Currency;

public enum Element
{
  LENGTH_OF_FIFTY(50, new Price(new BigDecimal("59"), Currency.getInstance("USD"))),
  LENGTH_OF_SEVENTY_FIVE(75, new Price(new BigDecimal("62"), Currency.getInstance("USD"))),
  LENGTH_OF_ONE_HUNDRED(100, new Price(new BigDecimal("90"), Currency.getInstance("USD"))),
  LENGTH_OF_ONE_HUNDRED_TWENTY(120, new Price(new BigDecimal("111"), Currency.getInstance("USD")));

  private final int size;
  private final Price price;

  Element(int size, Price price)
  {
    this.size = size;
    this.price = price;
  }

  public int getSize()
  {
    return size;
  }

  public Price getPrice()
  {
    return price;
  }

  @Override public String toString()
  {
    return "Element{" +
        "size=" + size +
        ", price=" + price +
        '}';
  }
}
