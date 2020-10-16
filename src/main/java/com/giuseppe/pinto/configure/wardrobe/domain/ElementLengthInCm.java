package com.giuseppe.pinto.configure.wardrobe.domain;

public enum ElementLengthInCm
{
  FIFTY(50),
  SEVENTY_FIVE(75);
  
  private final int size;

  ElementLengthInCm(int size)
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
