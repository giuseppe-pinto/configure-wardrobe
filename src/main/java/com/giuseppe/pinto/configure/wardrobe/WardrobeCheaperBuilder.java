package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.Combination;
import com.giuseppe.pinto.configure.wardrobe.domain.WardrobeElements;
import com.giuseppe.pinto.configure.wardrobe.logic.*;

import java.util.Optional;

public class WardrobeCheaperBuilder
{

  private CombinationsSupplier combinationsSupplier;
  private CombinationCheaperFinder combinationCheaperFinder;

  public WardrobeCheaperBuilder(CombinationsSupplier combinationsSupplier,
                                CombinationCheaperFinder combinationCheaperFinder)
  {
    this.combinationsSupplier = combinationsSupplier;
    this.combinationCheaperFinder = combinationCheaperFinder;
  }

  public Optional<Combination> from(WardrobeElements wardrobeElements)
  {
    return combinationCheaperFinder
        .apply(combinationsSupplier.from(wardrobeElements));
  }

}
