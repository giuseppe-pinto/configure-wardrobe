package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.*;

import java.util.*;

public class WardrobeCombinator
{

  public List<ElementsCombination> combine(int maxLengthWallInCm,
                                           WardrobeElements wardrobeElements)
  {

    List<ElementsCombination> combinations = new ArrayList<>();

    List<ElementLengthInCm> list = wardrobeElements.getElementLengthInCm();

    for (int i = 0; i < list.size(); i++)
    {
      for (int s = i; s < list.size(); s++)
      {
        for (int j = 0; j < 6; j++)
        {
          List<ElementLengthInCm> temp = new ArrayList<>();

          for (int k = 0; k < 5; k++)
          {
            if (calculateLength(temp) < maxLengthWallInCm)
            {
              if (j == 1 && k >= 4)
              {
                temp.add(list.get(s + 1));
              }
              else if (j == 2 && k >= 3)
              {
                temp.add(list.get(s + 1));
              }
              else if (j == 3 && k >= 2)
              {
                temp.add(list.get(s + 1));
              }
              else if (j == 4 && k >= 1)
              {
                temp.add(list.get(s + 1));
              }
              else if (j == 5)
              {
                temp.add(list.get(s + 1));
              }
              else
              {
                temp.add(list.get(i));
              }
            }
            if (calculateLength(temp) == maxLengthWallInCm)
            {
              if (!combinations.contains(new ElementsCombination(temp)))
              {
                combinations.add(new ElementsCombination(temp));
              }
            }
          }

          if (s + 1 == list.size())
            break;
        }
      }

    }
    return combinations;
  }

  private Integer calculateLength(List<ElementLengthInCm> combinations)
  {
    return combinations.stream().map(ElementLengthInCm::getSize).reduce(0, Integer::sum);
  }
  
  private List<ElementsCombination> calculateCombinationsFrom
      (ElementLengthInCm[][] matrixOfCombinations)
  {

    List<ElementsCombination> combinations = new ArrayList<>();

    for (int lines = 0; lines < 5; lines++)
    {
      List<ElementLengthInCm> temp = new ArrayList<>();

      for (int columns = 0; columns < 5; columns++)
      {
        if (calculateLength(temp) < 250)
        {
          temp.add(matrixOfCombinations[lines][columns]);
        }
      }

      if (calculateLength(temp) == 250)
      {
        combinations.add(new ElementsCombination(temp));
      }
    }

    return combinations;
  }

}
