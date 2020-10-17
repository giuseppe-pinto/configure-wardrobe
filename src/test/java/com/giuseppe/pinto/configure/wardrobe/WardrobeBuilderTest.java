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

class WardrobeBuilderTest
{

  private final int wallLength = 250;
  private final WardrobeBuilder wardrobeBuilder = new WardrobeBuilder(wallLength);

  @Test
  void bestsCombinationsWithSingleLengthElements()
  {
    WardrobeElements wardrobeElements = new WardrobeElements(Arrays.asList(LENGTH_OF_FIFTY));

    List<Combination> actualCombinations =
        wardrobeBuilder
            .with(wardrobeElements);

    List<Combination> expectedCombinations =
        singletonList(
            new Combination(
                Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY)));

    assertNotNull(actualCombinations);
    assertIterableEquals(expectedCombinations, actualCombinations);
  }

  @Test
  void bestsCombinationsWithTwoLengthElements()
  {
    WardrobeElements wardrobeElements = new WardrobeElements(Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_SEVENTY_FIVE));

    List<Combination> actualCombinations =
        wardrobeBuilder
            .with(wardrobeElements);

    Combination firstCombination = new Combination(
        Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY));

    Combination secondCombinations = new Combination(
        Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_SEVENTY_FIVE));

    assertThat(actualCombinations, containsInAnyOrder(firstCombination, secondCombinations));
  }

  @Test
  void bestsCombinationsWithMultiLengthElements()
  {

    WardrobeElements wardrobeElements = new WardrobeElements(Arrays.asList(LENGTH_OF_FIFTY,
                                                                           LENGTH_OF_SEVENTY_FIVE,
                                                                           LENGTH_OF_ONE_HUNDRED,
                                                                           LENGTH_OF_ONE_HUNDRED_TWENTY));

/*
    50cm => 59 USD
    75cm => 62 USD
    100cm => 90 USD
    120cm => 111 USD
*/

    List<Combination> actualCombinations =
        wardrobeBuilder
            .with(wardrobeElements);

    Combination firstCombination = new Combination(
        Arrays
            .asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY)); // -> 295 USD

    Combination secondCombinations = new Combination(
        Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_SEVENTY_FIVE)); // -> 224

    Combination thirdCombinations = new Combination(
        Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_ONE_HUNDRED)); // -> 267

    Combination fourthCombinations = new Combination(
        Arrays.asList(LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_ONE_HUNDRED)); // -> 214

    Combination fifthCombinations = new Combination(
        Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_ONE_HUNDRED, LENGTH_OF_ONE_HUNDRED)); // -> 239

    assertThat(actualCombinations, containsInAnyOrder(firstCombination,
                                                      secondCombinations,
                                                      thirdCombinations,
                                                      fourthCombinations,
                                                      fifthCombinations));
  }

}
