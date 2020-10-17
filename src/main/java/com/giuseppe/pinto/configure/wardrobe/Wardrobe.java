package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.*;

import java.util.*;
import java.util.function.Consumer;

public class Wardrobe
{

  private final MatrixCreator matrixCreator;
  private final CombinationsCalculator combinationsCalculator;

  public Wardrobe()
  {
    matrixCreator = new MatrixCreator();
    combinationsCalculator = new CombinationsCalculator();
  }

  public List<Combination> buildOn(int wallLength,
                                   WardrobeElements wardrobeElements)
  {

    List<Element> elements = wardrobeElements.getElements();
    List<Combination> combinations = new ArrayList<>();

    for (int i = 0; i < elements.size(); i++)
    {
      for (int j = i; j < elements.size(); j++)
      {
        Element[][] matrix = matrixCreator
            .invoke(elements.get(i), elements.get(j));

        List<Combination> elementsCombinations =
            combinationsCalculator.from(matrix, wallLength);

        elementsCombinations.forEach(ifNotPresentAddIn(combinations));
      }

    }

    return combinations;

  }

  private Consumer<Combination> ifNotPresentAddIn(List<Combination> combinations)
  {
    return combination -> {
      if (!combinations.contains(combination))
      {
        combinations.add(combination);
      }
    };
  }

}