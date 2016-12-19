package com.palmeroo.kata.yahtzee.calculators;

import com.palmeroo.kata.yahtzee.util.DieValue;
import com.palmeroo.kata.yahtzee.util.Roll;
import com.palmeroo.kata.yahtzee.util.Tally;

import java.util.Objects;
import java.util.function.Predicate;

class SumCalculator implements RollCalculator {
    private final Predicate<Tally> predicate;

    private SumCalculator(Predicate<Tally> predicate) {
        this.predicate = Objects.requireNonNull(predicate);
    }

    public static RollCalculator of(DieValue dieValue) {
        Objects.requireNonNull(dieValue);
        return new SumCalculator(Tally.matches(dieValue));
    }

    public static RollCalculator all() {
        return new SumCalculator(Tally.all());
    }

    @Override
    public int calculate(Roll roll) {
        Objects.requireNonNull(roll);
        return roll.sum(predicate);
    }
}
