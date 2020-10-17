package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.Element;
import com.giuseppe.pinto.configure.wardrobe.domain.Combination;
import com.giuseppe.pinto.configure.wardrobe.utilities.MatrixUtilities;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.giuseppe.pinto.configure.wardrobe.domain.Element.LENGTH_OF_FIFTY;
import static com.giuseppe.pinto.configure.wardrobe.domain.Element.LENGTH_OF_SEVENTY_FIVE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationsCalculatorTest
{

  public static final int MAX_LENGTH_WALL_IN_CM = 250;
  private final CombinationsCalculator calculator = new CombinationsCalculator();
  private final MatrixCreator matrixCreator = new MatrixCreator();

  @Test
  void calculateCombinationsForMatrixFiftySeventyFive()
  {

    Element[][] matrix = matrixCreator
        .invoke(LENGTH_OF_FIFTY, LENGTH_OF_SEVENTY_FIVE);

    List<Combination> actualCombinations = calculator.from(matrix, MAX_LENGTH_WALL_IN_CM);

    Combination expectedCombination = new Combination(
        Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_SEVENTY_FIVE, LENGTH_OF_SEVENTY_FIVE)
    );

    assertEquals(actualCombinations.size(), 1);
    assertThat(actualCombinations, contains(expectedCombination));
  }

  @Test
  void calculateCombinationWithSingleLineMatrix()
  {
    Element[][] matrix = new MatrixUtilities()
        .createMatrixOfElementsFrom("50 50 50 50 50");

    List<Combination> actualCombinations = calculator.from(matrix, MAX_LENGTH_WALL_IN_CM);

    Combination expectedCombination = new Combination(
        Arrays.asList(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY, LENGTH_OF_FIFTY)
    );

    assertEquals(actualCombinations.size(), 1);
    assertThat(actualCombinations, contains(expectedCombination));

  }
}