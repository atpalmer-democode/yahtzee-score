package com.palmeroo.kata.yahtzee.calculators;

import com.palmeroo.kata.yahtzee.util.Roll;
import com.palmeroo.kata.yahtzee.util.Tally;

import static com.palmeroo.kata.yahtzee.calculators.Calculator.DEFAULT_POINTS;

class FullHouseCalculator implements RollCalculator {
    private static final int FULL_HOUSE_POINTS = 25;

    private FullHouseCalculator() {
    }

    public static RollCalculator create() {
        return new FullHouseCalculator();
    }

    @Override
    public int calculate(Roll roll) {
        return roll.hasCondition(Tally.hasCount(3)) && roll.hasCondition(Tally.hasCount(2))
            ? FULL_HOUSE_POINTS
            : DEFAULT_POINTS;
    }
}
