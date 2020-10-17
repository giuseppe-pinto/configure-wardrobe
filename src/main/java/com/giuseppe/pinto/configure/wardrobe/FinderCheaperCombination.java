package com.giuseppe.pinto.configure.wardrobe;

import com.giuseppe.pinto.configure.wardrobe.domain.Combination;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;

import static java.util.AbstractMap.*;

public class FinderCheaperCombination implements Function<List<Combination>, Optional<Combination>>
{

  @Override
  public Optional<Combination> apply(List<Combination> combinations)
  {
    return combinations
        .stream()
        .map(combination ->
                 new SimpleEntry<>(combination,
                                   combination.getElements()
                                       .stream()
                                       .map(element -> element.getPrice().getValue())
                                       .reduce(BigDecimal.ZERO, BigDecimal::add)))
        .sorted(Entry.comparingByValue())
        .map(SimpleEntry::getKey)
        .findFirst();
  }
}
