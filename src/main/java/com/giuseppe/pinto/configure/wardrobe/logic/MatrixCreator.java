package com.giuseppe.pinto.configure.wardrobe.logic;

import com.giuseppe.pinto.configure.wardrobe.domain.Element;

public class MatrixCreator
{

  private static final int MAX_NUMBER_OF_ELEMENTS = 5;

  public Element[][] invoke(Element firstElement,
                            Element secondElement)
  {

    int numberOfLines = firstElement.equals(secondElement) ? 1 : MAX_NUMBER_OF_ELEMENTS;
    Element[][] matrix =
        new Element[numberOfLines][MAX_NUMBER_OF_ELEMENTS];

    for (int lines = 0; lines < numberOfLines; lines++)
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
