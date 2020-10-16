import com.giuseppe.pinto.configure.wardrobe.*;
import com.giuseppe.pinto.configure.wardrobe.domain.ElementSizeInCm;
import com.giuseppe.pinto.configure.wardrobe.domain.WardrobeElements;
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
    Set<ElementSizeInCm> elementSizeInCms = new HashSet<>();
    elementSizeInCms.add(ElementSizeInCm.FIFTY);
    WardrobeElements wardrobeElements = new WardrobeElements(elementSizeInCms);

    List<Integer> actualCombinations = new WardrobeCombinator()
        .combine(maxSizeWallInCm, wardrobeElements);
    
    List<Integer> expectedCombinations = Arrays.asList(50,50,50,50,50);
    
    assertNotNull(actualCombinations);
    assertIterableEquals(expectedCombinations, actualCombinations);
  }

  @Test
  void bestsCombinationsWithMultiSizeElements()
  {

    Set<ElementSizeInCm> elementSizeInCms = new HashSet<>();
    elementSizeInCms.add(ElementSizeInCm.FIFTY);
    
    WardrobeElements wardrobeElements = 
        new WardrobeElements(elementSizeInCms);
    
    
    
    
    
    

  }
}