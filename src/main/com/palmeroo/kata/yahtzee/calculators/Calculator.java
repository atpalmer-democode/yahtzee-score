package com.palmeroo.kata.yahtzee.calculators;

import com.palmeroo.kata.yahtzee.util.DieValue;
import com.palmeroo.kata.yahtzee.util.Roll;

public enum Calculator implements RollCalculator {
    CHANCE(SumCalculator.all()),
    ONES(SumCalculator.of(DieValue.ONE)),
    TWOS(SumCalculator.of(DieValue.TWO)),
    THREES(SumCalculator.of(DieValue.THREE)),
    FOURS(SumCalculator.of(DieValue.FOUR)),
    FIVES(SumCalculator.of(DieValue.FIVE)),
    SIXES(SumCalculator.of(DieValue.SIX)),
    PAIR(OfAKindCalculator.ofAKind(2)),
    THREE_OF_A_KIND(OfAKindCalculator.ofAKind(3)),
    FOUR_OF_A_KIND(OfAKindCalculator.ofAKind(4)),
    YAHTZEE(YahtzeeCalculator.create()),
    TWO_PAIR(TwoPairCalculator.create()),
    FULL_HOUSE(FullHouseCalculator.create()),
    SMALL_STRAIGHT(StraightCalculator.ofLength(4).ofPoints(15)),
    LARGE_STRAIGHT(StraightCalculator.ofLength(5).ofPoints(20));

    public static final int DEFAULT_POINTS = 0;

    private final RollCalculator calculator;

    Calculator(RollCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int calculate(Roll roll) {
        return calculator.calculate(roll);
    }
}
