package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.ElementLengthInCm;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.giuseppe.pinto.configure.wardrobe.domain.ElementLengthInCm.*;
import static org.junit.jupiter.api.Assertions.*;

class MatrixCreatorTest
{

  @Test
  void createMatrixFrom()
  {

    MatrixCreator creator = new MatrixCreator();

    ElementLengthInCm[][] actualMatrix = creator.invoke(FIFTY, SEVENTY_FIVE);

    String matrixInString = "50 50 50 50 75-"
        + "50 50 50 75 75-"
        + "50 50 75 75 75-"
        + "50 75 75 75 75-"
        + "75 75 75 75 75-";

    ElementLengthInCm[][] expectedMatrix = createMatrixFrom(matrixInString);

    assertEquals(Arrays.deepToString(actualMatrix), Arrays.deepToString(expectedMatrix));
  }

  private ElementLengthInCm[][] createMatrixFrom(String matrixInString)
  {
    ElementLengthInCm[][] expectedMatrix = new ElementLengthInCm[5][5];
    String[] lines = matrixInString.split("-");

    for (int i = 0; i < lines.length; i++)
    {
      String[] columns = lines[i].split(" ");
      for (int j = 0; j < columns.length; j++)
      {
        expectedMatrix[i][j] = adaptToElement(columns[j]);
      }
    }
    return expectedMatrix;
  }

  private ElementLengthInCm adaptToElement(String s)
  {
    if ("50".equals(s))
    {
      return FIFTY;
    }
    else if ("75".equals(s))
    {
      return SEVENTY_FIVE;
    }
    else if ("100".equals(s))
    {
      return ONE_HUNDRED;
    }
    else
    {
      return ONE_HUNDRED_TWENTY;
    }
  }
}