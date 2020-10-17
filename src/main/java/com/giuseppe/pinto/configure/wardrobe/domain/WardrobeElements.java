package com.giuseppe.pinto.configure.wardrobe.domain;

import java.util.List;

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
