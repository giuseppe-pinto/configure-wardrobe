package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.*;

import java.util.*;

import static java.util.Collections.*;

public class WardrobeCombinator
{

  public WardrobeCombinator()
  {
  }

  public List<ElementsCombination> combine(int maxSizeWallInCm,
                                           WardrobeElements wardrobeElements)
  {

    List<ElementSizeInCm> elementSizeInCmArrayList = new ArrayList<>();
    while (calculateSize(elementSizeInCmArrayList) < maxSizeWallInCm)
    {

      elementSizeInCmArrayList.addAll(new ArrayList<>(wardrobeElements.getElementSizeInCmSet()));

    }

    return singletonList(new ElementsCombination(elementSizeInCmArrayList));
  }

  private Integer calculateSize(List<ElementSizeInCm> combinations)
  {
    return combinations.stream().map(ElementSizeInCm::getSize).reduce(0, Integer::sum);
  }

}
