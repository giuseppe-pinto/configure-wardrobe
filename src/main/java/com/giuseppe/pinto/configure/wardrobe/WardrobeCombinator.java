package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.ElementSizeInCm;
import com.giuseppe.pinto.configure.wardrobe.domain.WardrobeElements;

import java.util.ArrayList;
import java.util.List;

public class WardrobeCombinator
{

  public WardrobeCombinator() { }

  public List<ElementSizeInCm> combine(int maxSizeWallInCm,
                                       WardrobeElements wardrobeElements){

    List<ElementSizeInCm> combinations = new ArrayList<>();
    
    while(calculateSize(combinations) < maxSizeWallInCm){
      
      combinations.addAll(new ArrayList<>(wardrobeElements.getElementSizeInCmSet()));
      
    }
    return combinations;
  }

  private Integer calculateSize(List<ElementSizeInCm> combinations)
  {
    return combinations.stream().map(ElementSizeInCm::getSize).reduce(0, Integer::sum);
  }

}
