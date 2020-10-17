package com.giuseppe.pinto.configure.wardrobe.domain;

public enum Element
{
  FIFTY(50),
  SEVENTY_FIVE(75),
  ONE_HUNDRED(100),
  ONE_HUNDRED_TWENTY(120);

  private final int size;

  Element(int size)
  {
    this.size = size;
  }

  public int getSize()
  {
    return size;
  }

  @Override public String toString()
  {
    return "ElementLengthInCm{" +
        "size=" + size +
        '}';
  }
}