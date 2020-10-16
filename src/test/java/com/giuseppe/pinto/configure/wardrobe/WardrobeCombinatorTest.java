package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.giuseppe.pinto.configure.wardrobe.domain.ElementLengthInCm.*;
import static java.util.Collections.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class WardrobeCombinatorTest
{

  private final WardrobeCombinator wardrobeCombinator = new WardrobeCombinator();
  private final int maxLengthWallInCm = 250;

  @Test
  void bestsCombinationsWithSingleLengthElements()
  {
    WardrobeElements wardrobeElements = createWardrobeElements(FIFTY);

    List<ElementsCombination> actualElementsCombinations =
        wardrobeCombinator
            .combine(maxLengthWallInCm, wardrobeElements);

    List<ElementsCombination> expectedElementsCombinations =
        singletonList(
            new ElementsCombination(
                Arrays.asList(FIFTY, FIFTY, FIFTY, FIFTY, FIFTY)));

    assertNotNull(actualElementsCombinations);
    assertIterableEquals(expectedElementsCombinations, actualElementsCombinations);
  }

  @Test
  void bestsCombinationsWithTwoLengthElements()
  {
    WardrobeElements wardrobeElements = createWardrobeElements(FIFTY,
                                                               SEVENTY_FIVE);

    List<ElementsCombination> actualElementsCombinations =
        wardrobeCombinator
            .combine(maxLengthWallInCm, wardrobeElements);

    ElementsCombination firstCombination = new ElementsCombination(
        Arrays.asList(FIFTY, FIFTY, FIFTY, FIFTY, FIFTY));

    ElementsCombination secondCombinations = new ElementsCombination(
        Arrays.asList(FIFTY, FIFTY, SEVENTY_FIVE, SEVENTY_FIVE));

    assertThat(actualElementsCombinations, containsInAnyOrder(firstCombination, secondCombinations));
  }

  @Test
  void bestsCombinationsWithMultiLengthElements()
  {

    WardrobeElements wardrobeElements = createWardrobeElements(FIFTY,
                                                               SEVENTY_FIVE,
                                                               ONE_HUNDRED,
                                                               ONE_HUNDRED_TWENTY);

    List<ElementsCombination> actualElementsCombinations =
        wardrobeCombinator
            .combine(maxLengthWallInCm, wardrobeElements);

    ElementsCombination firstCombination = new ElementsCombination(
        Arrays.asList(FIFTY, FIFTY, FIFTY, FIFTY, FIFTY));

    ElementsCombination secondCombinations = new ElementsCombination(
        Arrays.asList(FIFTY, FIFTY, SEVENTY_FIVE, SEVENTY_FIVE));

    ElementsCombination thirdCombinations = new ElementsCombination(
        Arrays.asList(FIFTY, FIFTY, FIFTY, ONE_HUNDRED));

    ElementsCombination fourthCombinations = new ElementsCombination(
        Arrays.asList(SEVENTY_FIVE, SEVENTY_FIVE, ONE_HUNDRED));

    ElementsCombination fifthCombinations = new ElementsCombination(
        Arrays.asList(FIFTY, ONE_HUNDRED, ONE_HUNDRED));

    assertThat(actualElementsCombinations, containsInAnyOrder(firstCombination,
                                                              secondCombinations,
                                                              thirdCombinations,
                                                              fourthCombinations,
                                                              fifthCombinations));
  }

  private WardrobeElements createWardrobeElements(ElementLengthInCm... elementLengthInCm)
  {
    return new WardrobeElements(Arrays.asList(elementLengthInCm));
  }

}
