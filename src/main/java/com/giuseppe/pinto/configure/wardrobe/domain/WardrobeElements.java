package com.giuseppe.pinto.configure.wardrobe.domain;

import java.util.Set;

public class WardrobeElements
{
  private final Set<ElementSizeInCm> elementSizeInCmSet;

  public WardrobeElements(Set<ElementSizeInCm> elementSizeInCmSet)
  {
    this.elementSizeInCmSet = elementSizeInCmSet;
  }

  public Set<ElementSizeInCm> getElementSizeInCmSet()
  {
    return elementSizeInCmSet;
  }
}
