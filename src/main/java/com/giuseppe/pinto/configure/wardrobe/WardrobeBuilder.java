package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.*;

import java.util.*;
import java.util.function.Consumer;

public class WardrobeBuilder
{

  private final MatrixCreator matrixCreator;
  private final CombinationsCalculator combinationsCalculator;
  private final int wallLength;

  public WardrobeBuilder(int wallLength)
  {
    this.wallLength = wallLength;
    matrixCreator = new MatrixCreator();
    combinationsCalculator = new CombinationsCalculator();
  }

  public List<Combination> with(WardrobeElements wardrobeElements)
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
