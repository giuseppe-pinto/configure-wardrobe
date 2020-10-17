package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.ElementLengthInCm;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.giuseppe.pinto.configure.wardrobe.domain.ElementLengthInCm.*;
import static org.junit.jupiter.api.Assertions.*;

class MatrixCreatorTest
{

  private final MatrixUtilities matrixUtilities = new MatrixUtilities();

  @Test
  void createMatrixFromString()
  {

    MatrixCreator creator = new MatrixCreator();

    ElementLengthInCm[][] actualMatrix = creator.invoke(FIFTY, SEVENTY_FIVE);

    String matrixInString = "50 50 50 50 75-"
        + "50 50 50 75 75-"
        + "50 50 75 75 75-"
        + "50 75 75 75 75-"
        + "75 75 75 75 75-";

    ElementLengthInCm[][] expectedMatrix =
        matrixUtilities.createMatrixOfElementsFrom(matrixInString);

    assertEquals(Arrays.deepToString(actualMatrix), Arrays.deepToString(expectedMatrix));
  }

}