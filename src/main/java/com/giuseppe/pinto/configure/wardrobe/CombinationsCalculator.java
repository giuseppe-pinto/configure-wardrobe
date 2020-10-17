package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.ElementLengthInCm;
import com.giuseppe.pinto.configure.wardrobe.domain.ElementsCombination;

import java.util.ArrayList;
import java.util.List;

public class CombinationsCalculator
{

  public List<ElementsCombination> from(ElementLengthInCm[][] matrixOfCombinations,
                                        int maxLengthWallInCm)
  {
    int numberOfLines = matrixOfCombinations.length;
    int numberOfColumns = matrixOfCombinations[0].length;
    List<ElementsCombination> combinations = new ArrayList<>();

    for (int lines = 0; lines < numberOfLines; lines++)
    {
      List<ElementLengthInCm> temp = new ArrayList<>();

      for (int columns = 0; columns < numberOfColumns; columns++)
      {
        if (calculateLength(temp) < maxLengthWallInCm)
        {
          temp.add(matrixOfCombinations[lines][columns]);
        }
      }

      if (calculateLength(temp) == maxLengthWallInCm)
      {
        combinations.add(new ElementsCombination(temp));
      }
    }

    return combinations;
  }

  private Integer calculateLength(List<ElementLengthInCm> combinations)
  {
    return combinations.stream().map(ElementLengthInCm::getSize).reduce(0, Integer::sum);
  }
}
