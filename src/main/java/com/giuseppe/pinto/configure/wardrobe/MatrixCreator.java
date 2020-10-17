package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.ElementLengthInCm;

public class MatrixCreator
{

  private static final int MAX_NUMBER_OF_ELEMENTS = 5;

  public ElementLengthInCm[][] invoke(ElementLengthInCm firstElement,
                                      ElementLengthInCm secondElement)
  {
    ElementLengthInCm[][] matrix =
        new ElementLengthInCm[MAX_NUMBER_OF_ELEMENTS][MAX_NUMBER_OF_ELEMENTS];

    for (int lines = 0; lines < MAX_NUMBER_OF_ELEMENTS; lines++)
    {

      for (int columns = 0; columns < MAX_NUMBER_OF_ELEMENTS; columns++)
      {
        matrix[lines][columns] =
            isUnderPrincipalDiagonal(lines, columns) ?
                secondElement :
                firstElement;
      }
    }
    return matrix;
  }

  private boolean isUnderPrincipalDiagonal(int lines, int columns)
  {
    return lines + columns >= 4;
  }
}
