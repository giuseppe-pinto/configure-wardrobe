package com.giuseppe.pinto.configure.wardrobe.logic;

import com.giuseppe.pinto.configure.wardrobe.domain.Combination;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.giuseppe.pinto.configure.wardrobe.domain.Element.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CombinationCheaperFinderTest
{

  private final CombinationCheaperFinder combinationCheaperFinder = new CombinationCheaperFinder();

  @Test
  void findCheaper()
  {

    Combination of295Usd = createCombinationOf295Usd();
    Combination of224Usd = createCombinationOf224Usd();
    Combination of267Usd = createCombinationOf267Usd();
    Combination of214Usd = createCombinationOf214Usd();
    Combination of239Usd = createCombinationOf239Usd();

    List<Combination> combinations = Arrays.asList(of295Usd,
                                                   of224Usd,
                                                   of267Usd,
                                                   of214Usd,
                                                   of239Usd);

    Optional<Combination> actualCombinations =
        combinationCheaperFinder.apply(combinations);

    assertTrue(actualCombinations.isPresent());
    assertEquals(of214Usd, actualCombinations.get());
  }

  @Test
  void findCheaperWithoutElements()
  {
    Optional<Combination> actualCombinations =
        combinationCheaperFinder.apply(new ArrayList<>());

    assertTrue(actualCombinations.isEmpty());
  }

  private Combination createCombinationOf239Usd()
  {
    return new Combination(
        Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_ONE_HUNDRED, LENGTH_OF_ONE_HUNDRED));
  }

  private Combination createCombinationOf214Usd()
  {
    return new Combination(
        Arrays.asList(LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_ONE_HUNDRED));
  }

  private Combination createCombinationOf267Usd()
  {
    return new Combination(
        Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_ONE_HUNDRED));
  }

  private Combination createCombinationOf224Usd()
  {
    return new Combination(
        Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_SEVENTY_FIVE));
  }

  private Combination createCombinationOf295Usd()
  {
    return new Combination(
        Arrays
            .asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY));
  }
}