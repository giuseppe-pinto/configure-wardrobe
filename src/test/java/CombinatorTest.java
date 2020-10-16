import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CombinatorTest
{

  private int maxSizeWallInCm = 250;

  @Test
  void bestsCombinationsWithSingleSizeElements()
  {
    WardrobeElements wardrobeElements = new WardrobeElements(singletonList(ElementSizeInCm.FIFTY));

    List<Integer> actualCombinations = new WardrobeCombinator()
        .combine(maxSizeWallInCm, wardrobeElements);
    
    List<Integer> expectedCombinations = Arrays.asList(50,50,50,50,50);
    
    assertNotNull(actualCombinations);
    assertIterableEquals(expectedCombinations, actualCombinations);
  }

  @Test
  @Disabled
  void bestsCombinationsWithMultiSizeElements()
  {
    WardrobeElements wardrobeElements = 
        new WardrobeElements(Arrays.asList(ElementSizeInCm.FIFTY));
    

  }
}