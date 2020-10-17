package com.giuseppe.pinto.configure.wardrobe.logic;

import com.giuseppe.pinto.configure.wardrobe.domain.Element;
import com.giuseppe.pinto.configure.wardrobe.domain.Combination;

import java.util.ArrayList;
import java.util.List;

public class CombinationsCalculator
{

  public List<Combination> from(Element[][] matrixOfCombinations, int wallLength)
  {
    int numberOfLines = matrixOfCombinations.length;
    int numberOfColumns = matrixOfCombinations[0].length;
    List<Combination> combinations = new ArrayList<>();

    for (int lines = 0; lines < numberOfLines; lines++)
    {
      List<Element> temp = new ArrayList<>();

      for (int columns = 0; columns < numberOfColumns; columns++)
      {
        if (calculateLength(temp) < wallLength)
        {
          temp.add(matrixOfCombinations[lines][columns]);
        }
      }

      if (calculateLength(temp) == wallLength)
      {
        combinations.add(new Combination(temp));
      }
    }

    return combinations;
  }

  private Integer calculateLength(List<Element> combinations)
  {
    return combinations.stream().map(Element::getSize).reduce(0, Integer::sum);
  }
}
