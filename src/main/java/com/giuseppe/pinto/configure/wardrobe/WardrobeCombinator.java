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

  public List<ElementsCombination> combine2(int maxLengthWallInCm,
                                            WardrobeElements wardrobeElements)
  {
    
    return null;

  }

}
