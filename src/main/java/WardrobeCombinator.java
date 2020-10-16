import java.util.ArrayList;
import java.util.List;

public class WardrobeCombinator
{

  public WardrobeCombinator() { }

  public List<Integer> combine(List<Integer> elementsSizes, int maxSizeWallInCm){

    List<Integer> combinations = new ArrayList<>();
    
    while(calculateSize(combinations) < maxSizeWallInCm){
      combinations.addAll(elementsSizes);
    }
    return combinations;
  }

  private Integer calculateSize(List<Integer> combinations)
  {
    return combinations.stream().reduce(0, Integer::sum);
  }

}
