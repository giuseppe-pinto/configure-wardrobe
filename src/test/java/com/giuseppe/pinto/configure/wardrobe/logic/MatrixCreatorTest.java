package com.giuseppe.pinto.configure.wardrobe.logic;

import com.giuseppe.pinto.configure.wardrobe.domain.Element;
import com.giuseppe.pinto.configure.wardrobe.logic.MatrixCreator;
import com.giuseppe.pinto.configure.wardrobe.utilities.MatrixUtilities;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.giuseppe.pinto.configure.wardrobe.domain.Element.*;
import static org.junit.jupiter.api.Assertions.*;

class MatrixCreatorTest
{

  private final MatrixUtilities matrixUtilities = new MatrixUtilities();

  @Test
  void createMatrixFromString()
  {

    MatrixCreator creator = new MatrixCreator();

    Element[][] actualMatrix = creator.invoke(LENGTH_OF_FIFTY, LENGTH_OF_SEVENTY_FIVE);

    String matrixInString = "50 50 50 50 75-"
        + "50 50 50 75 75-"
        + "50 50 75 75 75-"
        + "50 75 75 75 75-"
        + "75 75 75 75 75-";

    Element[][] expectedMatrix =
        matrixUtilities.createMatrixOfElementsFrom(matrixInString);

    assertEquals(Arrays.deepToString(actualMatrix), Arrays.deepToString(expectedMatrix));
  }

  @Test
  void createSingleLineMatrix()
  {

    MatrixCreator creator = new MatrixCreator();

    Element[][] actualMatrix = creator.invoke(LENGTH_OF_FIFTY, LENGTH_OF_FIFTY);

    String matrixInString = "50 50 50 50 50";

    Element[][] expectedMatrix =
        matrixUtilities.createMatrixOfElementsFrom(matrixInString);

    assertEquals(Arrays.deepToString(expectedMatrix), Arrays.deepToString(actualMatrix));

  }
}