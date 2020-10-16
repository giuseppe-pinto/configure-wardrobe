import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;

class CombinatorTest
{

  @Test
  void calculateTheBestsCombinationsWithSingleElementAndSingleSize()
  {
    int maxSizeWallInCm = 250;
    WardrobeElements wardrobeElements = new WardrobeElements(ElementSizeInCm.FIFTY);

    WardrobeCombinator wardrobeCombinator = new WardrobeCombinator();
    
    List<Integer> actualCombinations = wardrobeCombinator.combine(maxSizeWallInCm, wardrobeElements);
    List<Integer> expectedCombinations = Arrays.asList(50,50,50,50,50);
    
    assertNotNull(actualCombinations);
    assertIterableEquals(expectedCombinations, actualCombinations);
  }
}