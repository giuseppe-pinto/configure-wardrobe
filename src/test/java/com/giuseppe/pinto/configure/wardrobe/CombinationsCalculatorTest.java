package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.ElementLengthInCm;
import com.giuseppe.pinto.configure.wardrobe.domain.ElementsCombination;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.giuseppe.pinto.configure.wardrobe.domain.ElementLengthInCm.FIFTY;
import static com.giuseppe.pinto.configure.wardrobe.domain.ElementLengthInCm.SEVENTY_FIVE;
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

    ElementLengthInCm[][] matrix = matrixCreator
        .invoke(FIFTY, SEVENTY_FIVE);

    List<ElementsCombination> actualCombinations = calculator.from(matrix, MAX_LENGTH_WALL_IN_CM);

    ElementsCombination expectedCombination = new ElementsCombination(
        Arrays.asList(FIFTY, FIFTY, SEVENTY_FIVE, SEVENTY_FIVE)
    );

    assertEquals(actualCombinations.size(), 1);
    assertThat(actualCombinations, contains(expectedCombination));
  }

  @Test
  void calculateCombinationWithSingleLineMatrix()
  {
    ElementLengthInCm[][] matrix = new MatrixUtilities()
        .createMatrixOfElementsFrom("50 50 50 50 50");

    List<ElementsCombination> actualCombinations = calculator.from(matrix, MAX_LENGTH_WALL_IN_CM);

    ElementsCombination expectedCombination = new ElementsCombination(
        Arrays.asList(FIFTY, FIFTY, FIFTY, FIFTY, FIFTY)
    );

    assertEquals(actualCombinations.size(), 1);
    assertThat(actualCombinations, contains(expectedCombination));

  }
}