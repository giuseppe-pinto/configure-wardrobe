import com.giuseppe.pinto.configure.wardrobe.*;
import com.giuseppe.pinto.configure.wardrobe.domain.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.giuseppe.pinto.configure.wardrobe.domain.ElementSizeInCm.*;
import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WardrobeCombinatorTest
{

  private final WardrobeCombinator wardrobeCombinator = new WardrobeCombinator();
  private int maxSizeWallInCm = 250;

  @Test
  void bestsCombinationsWithSingleSizeElements()
  {

    WardrobeElements wardrobeElements = createWardrobeElements(FIFTY);

    List<ElementsCombination> actualElementsCombinations =
        wardrobeCombinator
            .combine(maxSizeWallInCm, wardrobeElements);

    List<ElementsCombination> expectedElementsCombinations =
        singletonList(
            new ElementsCombination(
                Arrays.asList(FIFTY, FIFTY, FIFTY, FIFTY, FIFTY)));

    assertNotNull(actualElementsCombinations);
    assertIterableEquals(expectedElementsCombinations, actualElementsCombinations);
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
