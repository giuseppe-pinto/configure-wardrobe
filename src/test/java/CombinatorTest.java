import com.giuseppe.pinto.configure.wardrobe.*;
import com.giuseppe.pinto.configure.wardrobe.domain.ElementSizeInCm;
import com.giuseppe.pinto.configure.wardrobe.domain.WardrobeElements;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CombinatorTest
{

  private int maxSizeWallInCm = 250;

  @Test
  void bestsCombinationsWithSingleSizeElements()
  {
    WardrobeElements wardrobeElements = createWardrobeElements(ElementSizeInCm.FIFTY);

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
    
    WardrobeElements wardrobeElements = createWardrobeElements(ElementSizeInCm.FIFTY,
                                                               ElementSizeInCm.SEVENTY_FIVE);
    
    
    
    
    
  }
  
  private WardrobeElements createWardrobeElements(ElementSizeInCm... elementSizeInCm)
  {
    Set<ElementSizeInCm> elementSizeInCms = new HashSet<>(Arrays.asList(elementSizeInCm));
    return new WardrobeElements(elementSizeInCms);
  }
  
}
