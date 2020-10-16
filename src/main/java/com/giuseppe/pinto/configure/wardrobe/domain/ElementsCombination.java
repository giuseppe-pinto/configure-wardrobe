package com.giuseppe.pinto.configure.wardrobe.domain;

import java.util.List;
import java.util.Objects;

public class ElementsCombination
{
  private final List<ElementLengthInCm> elementLengthInCmList;

  public ElementsCombination(List<ElementLengthInCm> elementLengthInCmList)
  {
    this.elementLengthInCmList = elementLengthInCmList;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    ElementsCombination that = (ElementsCombination) o;
    return Objects.equals(elementLengthInCmList, that.elementLengthInCmList);
  }

  @Override public int hashCode()
  {
    return Objects.hash(elementLengthInCmList);
  }

  @Override public String toString()
  {
    return "ElementsCombination{" +
        "elementLengthInCmList=" + elementLengthInCmList +
        '}';
  }
}
