import com.giuseppe.pinto.configure.wardrobe.*;
import com.giuseppe.pinto.configure.wardrobe.domain.ElementSizeInCm;
import com.giuseppe.pinto.configure.wardrobe.domain.WardrobeElements;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.giuseppe.pinto.configure.wardrobe.domain.ElementSizeInCm.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CombinatorTest
{

  private int maxSizeWallInCm = 250;

  @Test
  void bestsCombinationsWithSingleSizeElements()
  {
    WardrobeElements wardrobeElements = createWardrobeElements(FIFTY);

    List<ElementSizeInCm> actualCombinations = new WardrobeCombinator()
        .combine(maxSizeWallInCm, wardrobeElements);
    
    List<ElementSizeInCm> expectedCombinations = Arrays.asList(FIFTY,FIFTY,FIFTY,FIFTY,FIFTY);
    
    assertNotNull(actualCombinations);
    assertIterableEquals(expectedCombinations, actualCombinations);
  }


  @Test
  @Disabled
  void bestsCombinationsWithMultiSizeElements()
  {
    
    WardrobeElements wardrobeElements = createWardrobeElements(FIFTY,
                                                               SEVENTY_FIVE);
    
    
    
    
    
  }
  
  private WardrobeElements createWardrobeElements(ElementSizeInCm... elementSizeInCm)
  {
    Set<ElementSizeInCm> elementSizeInCms = new HashSet<>(Arrays.asList(elementSizeInCm));
    return new WardrobeElements(elementSizeInCms);
  }
  
}
