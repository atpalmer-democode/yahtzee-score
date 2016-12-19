package com.palmeroo.kata.yahtzee.calculators;

import com.palmeroo.kata.yahtzee.util.Roll;
import com.palmeroo.kata.yahtzee.util.Tally;

import java.util.Objects;

import static com.palmeroo.kata.yahtzee.calculators.Calculator.DEFAULT_POINTS;

class YahtzeeCalculator implements RollCalculator {
    private static final int YAHTZEE_POINTS = 50;

    private YahtzeeCalculator() {
    }

    public static RollCalculator create() {
        return new YahtzeeCalculator();
    }

    @Override
    public int calculate(Roll roll) {
        Objects.requireNonNull(roll);
        return roll.hasCondition(Tally.hasCount(5))
            ? YAHTZEE_POINTS
            : DEFAULT_POINTS;
    }
}
