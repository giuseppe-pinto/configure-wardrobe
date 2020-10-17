package com.giuseppe.pinto.configure.wardrobe.utilities;

import com.giuseppe.pinto.configure.wardrobe.domain.Element;

import static com.giuseppe.pinto.configure.wardrobe.domain.Element.*;

public class MatrixUtilities
{

  public Element[][] createMatrixOfElementsFrom(String matrixInString)
  {
    String[] lines = matrixInString.split("-");
    Element[][] matrix = new Element[lines.length][5];

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

  private Element adaptToElement(String s)
  {
    if ("50".equals(s))
    {
      return LENGTH_OF_FIFTY;
    }
    else if ("75".equals(s))
    {
      return LENGTH_OF_SEVENTY_FIVE;
    }
    else if ("100".equals(s))
    {
      return LENGTH_OF_ONE_HUNDRED;
    }
    else
    {
      return LENGTH_OF_ONE_HUNDRED_TWENTY;
    }
  }
}
