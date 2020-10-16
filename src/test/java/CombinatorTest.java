import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;

class CombinatorTest
{

  @Test
  void calculateTheBestsCombinationsWithSingleElementAndSingleSize()
  {
    List<Integer> elementsSizes = singletonList(50);
    int maxSizeWallInCm = 250;
    
    WardrobeCombinator wardrobeCombinator = new WardrobeCombinator();
    
    List<Integer> actualCombinations = wardrobeCombinator.combine(elementsSizes, maxSizeWallInCm);
    List<Integer> expectedCombinations = Arrays.asList(50,50,50,50,50);
    
    assertNotNull(actualCombinations);
    assertIterableEquals(expectedCombinations, actualCombinations);
  }
}