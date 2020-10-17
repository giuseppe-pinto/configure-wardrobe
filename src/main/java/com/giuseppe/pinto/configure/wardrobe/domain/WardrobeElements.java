package com.giuseppe.pinto.configure.wardrobe.domain;

import java.util.List;

public class WardrobeElements
{
  private final List<Element> elements;

  public WardrobeElements(List<Element> elements)
  {
    this.elements = elements;
  }

  public List<Element> getElements()
  {
    return elements;
  }
}
