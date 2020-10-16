import java.util.ArrayList;
import java.util.List;

public class WardrobeCombinator
{

  public WardrobeCombinator() { }

  public List<Integer> combine(int maxSizeWallInCm,
                               WardrobeElements wardrobeElements){

    List<Integer> combinations = new ArrayList<>();
    
    while(calculateSize(combinations) < maxSizeWallInCm){
      combinations.add(wardrobeElements.getElementSize().getSize());
    }
    return combinations;
  }

  private Integer calculateSize(List<Integer> combinations)
  {
    return combinations.stream().reduce(0, Integer::sum);
  }

}
