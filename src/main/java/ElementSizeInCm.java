public enum ElementSizeInCm
{
  FIFTY(50);
  
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
