public enum ElementSizeInCm
{
  FIFTY(50),
  SEVENTY_FIVE(75);
  
  private final int size;

  ElementSizeInCm(int size)
  {
    this.size = size;
  }

  public int getSize()
  {
    return size;
  }

}
