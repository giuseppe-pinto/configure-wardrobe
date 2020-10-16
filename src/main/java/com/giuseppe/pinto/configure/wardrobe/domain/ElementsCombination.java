package com.giuseppe.pinto.configure.wardrobe.domain;

import java.util.List;
import java.util.Objects;

public class ElementsCombination
{
  private final List<ElementSizeInCm> elementSizeInCmList;

  public ElementsCombination(List<ElementSizeInCm> elementSizeInCmList)
  {
    this.elementSizeInCmList = elementSizeInCmList;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    ElementsCombination that = (ElementsCombination) o;
    return Objects.equals(elementSizeInCmList, that.elementSizeInCmList);
  }

  @Override public int hashCode()
  {
    return Objects.hash(elementSizeInCmList);
  }
}
