package com.giuseppe.pinto.configure.wardrobe.logic;

import com.giuseppe.pinto.configure.wardrobe.domain.*;
import com.giuseppe.pinto.configure.wardrobe.logic.CombinationsSupplier;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.giuseppe.pinto.configure.wardrobe.domain.Element.*;
import static java.util.Collections.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class CombinationsSupplierTest
{

  private final int wallLength = 250;
  private final CombinationsSupplier combinationsSupplier = new CombinationsSupplier(wallLength);

  @Test
  void bestsCombinationsWithSingleLengthElements()
  {
    WardrobeElements wardrobeElements = new WardrobeElements(Arrays.asList(LENGTH_OF_FIFTY));

    List<Combination> actualCombinations =
        combinationsSupplier
            .from(wardrobeElements);

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
        combinationsSupplier
            .from(wardrobeElements);

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

    List<Combination> actualCombinations =
        combinationsSupplier
            .from(wardrobeElements);

    Combination firstCombination = new Combination(
        Arrays
            .asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY));

    Combination secondCombinations = new Combination(
        Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_SEVENTY_FIVE));

    Combination thirdCombinations = new Combination(
        Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_ONE_HUNDRED));

    Combination fourthCombinations = new Combination(
        Arrays.asList(LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_ONE_HUNDRED));

    Combination fifthCombinations = new Combination(
        Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_ONE_HUNDRED, LENGTH_OF_ONE_HUNDRED));

    assertThat(actualCombinations, containsInAnyOrder(firstCombination,
                                                      secondCombinations,
                                                      thirdCombinations,
                                                      fourthCombinations,
                                                      fifthCombinations));
  }

}
