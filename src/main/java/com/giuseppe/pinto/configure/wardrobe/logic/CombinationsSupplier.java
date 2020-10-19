package com.giuseppe.pinto.configure.wardrobe.logic;

import com.giuseppe.pinto.configure.wardrobe.domain.Combination;
import com.giuseppe.pinto.configure.wardrobe.domain.WardrobeElements;

import java.util.List;

public interface CombinationsSupplier
{
  List<Combination> from(WardrobeElements wardrobeElements);
}
