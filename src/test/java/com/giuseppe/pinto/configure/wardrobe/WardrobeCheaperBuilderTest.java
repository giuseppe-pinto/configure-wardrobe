package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.Combination;
import com.giuseppe.pinto.configure.wardrobe.domain.WardrobeElements;
import com.giuseppe.pinto.configure.wardrobe.logic.CombinationCheaperFinder;
import com.giuseppe.pinto.configure.wardrobe.logic.CombinationsSupplier;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static com.giuseppe.pinto.configure.wardrobe.domain.Element.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WardrobeCheaperBuilderTest
{

  @Test
  void findTheBestCombination()
  {
    WardrobeElements wardrobeElements = new WardrobeElements(Arrays.asList(LENGTH_OF_FIFTY,
                                                                           LENGTH_OF_SEVENTY_FIVE,
                                                                           LENGTH_OF_ONE_HUNDRED,
                                                                           LENGTH_OF_ONE_HUNDRED_TWENTY));
    Combination expectedCheaperCombination = new Combination(
        Arrays.asList(LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_ONE_HUNDRED));

    WardrobeCheaperBuilder builder = new WardrobeCheaperBuilder(new CombinationsSupplier(250),
                                                                new CombinationCheaperFinder());

    Optional<Combination> actualCombination = builder.from(wardrobeElements);

    assertTrue(actualCombination.isPresent());
    assertEquals(expectedCheaperCombination, actualCombination.get());
  }
}