package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.ElementLengthInCm;

public class MatrixCreator
{

  public ElementLengthInCm[][] invoke(ElementLengthInCm firstElement,
                                      ElementLengthInCm secondElement)
  {
    ElementLengthInCm[][] matrix =
        new ElementLengthInCm[5][5];

    for (int lines = 0; lines < 5; lines++)
    {

      for (int columns = 0; columns < 5; columns++)
      {
        if (lines + columns >= 4)
        {
          matrix[lines][columns] = secondElement;
        }
        else
        {
          matrix[lines][columns] = firstElement;
        }
      }
    }
    return matrix;
  }
}
