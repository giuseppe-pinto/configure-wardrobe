package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.ElementSizeInCm;
import com.giuseppe.pinto.configure.wardrobe.domain.WardrobeElements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WardrobeCombinator
{

  public WardrobeCombinator() { }

  public List<Integer> combine(int maxSizeWallInCm,
                               WardrobeElements wardrobeElements){

    List<Integer> combinations = new ArrayList<>();
    
    while(calculateSize(combinations) < maxSizeWallInCm){
      
      combinations.addAll(wardrobeElements
                              .getElementSizeInCmList()
                              .stream()
                              .map(ElementSizeInCm::getSize)
                              .collect(Collectors.toList()));
      
    }
    return combinations;
  }

  private Integer calculateSize(List<Integer> combinations)
  {
    return combinations.stream().reduce(0, Integer::sum);
  }

}
