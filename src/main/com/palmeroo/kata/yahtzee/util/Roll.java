package com.palmeroo.kata.yahtzee.util;

import com.palmeroo.kata.yahtzee.calculators.Calculator;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Roll {
    private static final Collector<DieValue, TreeMap<DieValue, Tally>, Collection<Tally>> TALLY_COLLECTOR =
        Collector.of(
            () -> new TreeMap<DieValue, Tally>(Comparator.reverseOrder()),
            (tree, die) -> tree.merge(die, Tally.of(die), (old, current) -> old.increment()),
            (left, right) -> { left.putAll(right); return left; },
            t -> t.values(),
            Collector.Characteristics.UNORDERED
        );

    private final Collection<Tally> tallies;

    private Roll(Collection<Tally> tallies) {
        assert tallies != null;
        this.tallies = tallies;
    }

    public static Roll of(int d1, int d2, int d3, int d4, int d5) {
        Stream<DieValue> roll = Stream.of(
            DieValue.of(d1),
            DieValue.of(d2),
            DieValue.of(d3),
            DieValue.of(d4),
            DieValue.of(d5)
        );
        return new Roll(roll.collect(TALLY_COLLECTOR));
    }

    public int scoreAs(Calculator calculator) {
        Objects.requireNonNull(calculator);
        return calculator.calculate(this);
    }

    public int sum(Predicate<Tally> predicate) {
        return tallies.stream()
            .filter(predicate)
            .mapToInt(t -> t.die().toInt() * t.count())
            .sum();
    }

    public Stream<DieValue> orderedStream() {
        return tallies.stream().map(t -> t.die());
    }

    public List<DieValue> where(Predicate<Tally> predicate) {
        return this.tallies.stream()
            .filter(predicate)
            .map(t -> t.die())
            .collect(Collectors.toList());
    }

    public boolean hasCondition(Predicate<Tally> predicate) {
        return this.tallies.stream().anyMatch(predicate);
    }
}
