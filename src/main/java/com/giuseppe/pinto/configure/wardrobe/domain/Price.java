package com.giuseppe.pinto.configure.wardrobe.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Price
{
  private final BigDecimal value;
  private final Currency currency;

  public Price(BigDecimal value, Currency currency)
  {

    this.value = value;
    this.currency = currency;
  }

  public BigDecimal getValue()
  {
    return value;
  }

  public Currency getCurrency()
  {
    return currency;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Price price = (Price) o;
    return Objects.equals(value, price.value) &&
        Objects.equals(currency, price.currency);
  }

  @Override public int hashCode()
  {
    return Objects.hash(value, currency);
  }

  @Override public String toString()
  {
    return "Price{" +
        "value=" + value +
        ", currency=" + currency +
        '}';
  }
}
