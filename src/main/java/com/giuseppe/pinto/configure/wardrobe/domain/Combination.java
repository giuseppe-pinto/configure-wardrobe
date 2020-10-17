package com.giuseppe.pinto.configure.wardrobe.domain;

import java.util.List;
import java.util.Objects;

public class Combination
{

  private final List<Element> elements;

  public Combination(List<Element> elements)
  {
    this.elements = elements;
  }

  public List<Element> getElements()
  {
    return elements;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Combination that = (Combination) o;
    return Objects.equals(elements, that.elements);
  }

  @Override public int hashCode()
  {
    return Objects.hash(elements);
  }

  @Override public String toString()
  {
    return "Combination{" +
        "elements=" + elements +
        '}';
  }
}
