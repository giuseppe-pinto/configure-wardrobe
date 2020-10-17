package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.*;

import java.util.*;
import java.util.function.Consumer;

public class WardrobeCombinator
{

  private final MatrixCreator matrixCreator;
  private final CombinationsCalculator combinationsCalculator;

  public WardrobeCombinator()
  {
    matrixCreator = new MatrixCreator();
    combinationsCalculator = new CombinationsCalculator();
  }

  public List<ElementsCombination> combine(int maxLengthWallInCm,
                                           WardrobeElements wardrobeElements)
  {

    List<ElementLengthInCm> elements = wardrobeElements.getElementLengthInCm();
    List<ElementsCombination> combinations = new ArrayList<>();

    for (int i = 0; i < elements.size(); i++)
    {
      for (int j = i; j < elements.size(); j++)
      {
        ElementLengthInCm[][] matrix = matrixCreator
            .invoke(elements.get(i), elements.get(j));

        List<ElementsCombination> elementsCombinations =
            combinationsCalculator.from(matrix, maxLengthWallInCm);

        elementsCombinations.forEach(ifNotPresentAddIn(combinations));
      }

    }

    return combinations;

  }

  private Consumer<ElementsCombination> ifNotPresentAddIn(List<ElementsCombination> combinations)
  {
    return combination -> {
      if (!combinations.contains(combination))
      {
        combinations.add(combination);
      }
    };
  }

}
