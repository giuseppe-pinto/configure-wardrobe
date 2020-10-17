package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.giuseppe.pinto.configure.wardrobe.domain.Element.*;
import static java.util.Collections.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class WardrobeTest
{

  private final int wallLength = 250;
  private final WardrobeBuilder wardrobeBuilder = new WardrobeBuilder(wallLength);

  @Test
  void bestsCombinationsWithSingleLengthElements()
  {
    WardrobeElements wardrobeElements = createWardrobeElements(FIFTY);

    List<Combination> actualCombinations =
        wardrobeBuilder
            .with(wardrobeElements);

    List<Combination> expectedCombinations =
        singletonList(
            new Combination(
                Arrays.asList(FIFTY, FIFTY, FIFTY, FIFTY, FIFTY)));

    assertNotNull(actualCombinations);
    assertIterableEquals(expectedCombinations, actualCombinations);
  }

  @Test
  void bestsCombinationsWithTwoLengthElements()
  {
    WardrobeElements wardrobeElements = createWardrobeElements(FIFTY,
                                                               SEVENTY_FIVE);

    List<Combination> actualCombinations =
        wardrobeBuilder
            .with(wardrobeElements);

    Combination firstCombination = new Combination(
        Arrays.asList(FIFTY, FIFTY, FIFTY, FIFTY, FIFTY));

    Combination secondCombinations = new Combination(
        Arrays.asList(FIFTY, FIFTY, SEVENTY_FIVE, SEVENTY_FIVE));

    assertThat(actualCombinations, containsInAnyOrder(firstCombination, secondCombinations));
  }

  @Test
  void bestsCombinationsWithMultiLengthElements()
  {

    WardrobeElements wardrobeElements = createWardrobeElements(FIFTY,
                                                               SEVENTY_FIVE,
                                                               ONE_HUNDRED,
                                                               ONE_HUNDRED_TWENTY);

    List<Combination> actualCombinations =
        wardrobeBuilder
            .with(wardrobeElements);

    Combination firstCombination = new Combination(
        Arrays.asList(FIFTY, FIFTY, FIFTY, FIFTY, FIFTY));

    Combination secondCombinations = new Combination(
        Arrays.asList(FIFTY, FIFTY, SEVENTY_FIVE, SEVENTY_FIVE));

    Combination thirdCombinations = new Combination(
        Arrays.asList(FIFTY, FIFTY, FIFTY, ONE_HUNDRED));

    Combination fourthCombinations = new Combination(
        Arrays.asList(SEVENTY_FIVE, SEVENTY_FIVE, ONE_HUNDRED));

    Combination fifthCombinations = new Combination(
        Arrays.asList(FIFTY, ONE_HUNDRED, ONE_HUNDRED));

    assertThat(actualCombinations, containsInAnyOrder(firstCombination,
                                                      secondCombinations,
                                                      thirdCombinations,
                                                      fourthCombinations,
                                                      fifthCombinations));
  }

  private WardrobeElements createWardrobeElements(Element... element)
  {
    return new WardrobeElements(Arrays.asList(element));
  }

}
