import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;

class CombinatorTest
{

  @Test
  void calculateTheBestsCombinationsWithSingleElementsAndSingleSize()
  {
    List<Integer> elementsSizes = singletonList(50);
    int maxSizeWallInCm = 250;
    
    WardrobeCombinator wardrobeCombinator = new WardrobeCombinator();
    
    List<Integer> combinations = wardrobeCombinator.combine(elementsSizes, maxSizeWallInCm);

    List<Integer> expected = Arrays.asList(50,50,50,50,50);
    
    assertNotNull(combinations);
    assertIterableEquals(expected, combinations);
  }
}