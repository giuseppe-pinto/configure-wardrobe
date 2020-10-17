package com.giuseppe.pinto.configure.wardrobe.logic;

import com.giuseppe.pinto.configure.wardrobe.domain.Combination;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static java.util.AbstractMap.Entry;
import static java.util.AbstractMap.SimpleEntry;

public class CombinationCheaperFinder
{

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
