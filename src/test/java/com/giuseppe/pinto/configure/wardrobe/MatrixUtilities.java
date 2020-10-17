package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.ElementLengthInCm;

import static com.giuseppe.pinto.configure.wardrobe.domain.ElementLengthInCm.*;

public class MatrixUtilities
{

  public ElementLengthInCm[][] createMatrixOfElementsFrom(String matrixInString)
  {
    String[] lines = matrixInString.split("-");
    ElementLengthInCm[][] matrix = new ElementLengthInCm[lines.length][5];

    for (int i = 0; i < lines.length; i++)
    {
      String[] columns = lines[i].split(" ");
      for (int j = 0; j < columns.length; j++)
      {
        matrix[i][j] = adaptToElement(columns[j]);
      }
    }
    return matrix;
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
