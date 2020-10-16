package com.giuseppe.pinto.configure.wardrobe.domain;

import java.util.List;
import java.util.Set;

public class WardrobeElements
{
  private final List<ElementLengthInCm> elementLengthInCmList;

  public WardrobeElements(List<ElementLengthInCm> elementLengthInCmList)
  {
    this.elementLengthInCmList = elementLengthInCmList;
  }

  public List<ElementLengthInCm> getElementLengthInCm()
  {
    return elementLengthInCmList;
  }
}
