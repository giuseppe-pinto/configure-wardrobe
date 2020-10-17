package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.Combination;
import com.giuseppe.pinto.configure.wardrobe.domain.WardrobeElements;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.giuseppe.pinto.configure.wardrobe.domain.Element.*;
import static com.giuseppe.pinto.configure.wardrobe.domain.Element.LENGTH_OF_ONE_HUNDRED_TWENTY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheaperCombinationTest
{

  private final FinderCheaperCombination finderCheaperCombination = new FinderCheaperCombination();

  @Test
  void findCheaper()
  {
    WardrobeBuilder wardrobeBuilder = new WardrobeBuilder(250);

    WardrobeElements wardrobeElements = new WardrobeElements(Arrays.asList(LENGTH_OF_FIFTY,
                                                                           LENGTH_OF_SEVENTY_FIVE,
                                                                           LENGTH_OF_ONE_HUNDRED,
                                                                           LENGTH_OF_ONE_HUNDRED_TWENTY));

    List<Combination> combinations =
        wardrobeBuilder.with(wardrobeElements);

    Optional<Combination> actualCombinations =
        finderCheaperCombination.apply(combinations);

    Combination expectedCombination = new Combination(
        Arrays.asList(LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_ONE_HUNDRED));

    assertTrue(actualCombinations.isPresent());
    assertEquals(expectedCombination, actualCombinations.get());
  }

  @Test
  void findCheaperWithoutElements()
  {
    Optional<Combination> actualCombinations =
        finderCheaperCombination.apply(new ArrayList<>());

    assertTrue(actualCombinations.isEmpty());
  }
}