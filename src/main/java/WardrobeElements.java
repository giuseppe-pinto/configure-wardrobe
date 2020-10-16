import java.util.List;

public class WardrobeElements
{
  private List<ElementSizeInCm> elementSizeInCmList;

  public WardrobeElements(List<ElementSizeInCm> elementSizeInCmList)
  {
    this.elementSizeInCmList = elementSizeInCmList;
  }

  public List<ElementSizeInCm> getElementSizeInCmList()
  {
    return elementSizeInCmList;
  }
}
