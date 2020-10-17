package com.giuseppe.pinto.configure.wardrobe.domain;

import java.util.List;
import java.util.Objects;

public class Combination
{
  private final List<Element> elementList;

  public Combination(List<Element> elementList)
  {
    this.elementList = elementList;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Combination that = (Combination) o;
    return Objects.equals(elementList, that.elementList);
  }

  @Override public int hashCode()
  {
    return Objects.hash(elementList);
  }

  @Override public String toString()
  {
    return "Combination{" +
        "elementList=" + elementList +
        '}';
  }
}
