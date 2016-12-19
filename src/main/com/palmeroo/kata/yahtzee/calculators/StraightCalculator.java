package com.palmeroo.kata.yahtzee.calculators;

import com.palmeroo.kata.yahtzee.util.DieValue;
import com.palmeroo.kata.yahtzee.util.Roll;

import java.util.*;
import java.util.stream.Collector;

import static com.palmeroo.kata.yahtzee.calculators.Calculator.DEFAULT_POINTS;

class StraightCalculator implements RollCalculator {
    public interface StraightCalculatorFactory {
        RollCalculator ofPoints(int pointValue);
    }

    private final int minStraightLength;
    private final int pointValue;

    private StraightCalculator(int straightLength, int pointValue) {
        this.minStraightLength = straightLength;
        this.pointValue = pointValue;
    }

    public static StraightCalculatorFactory ofLength(int straightLength) {
        return pointValue -> new StraightCalculator(straightLength, pointValue);
    }

    @Override
    public int calculate(Roll roll) {
        Objects.requireNonNull(roll);
        return StraightLengthCounter.calculate(roll) >= minStraightLength
            ? this.pointValue
            : DEFAULT_POINTS;
    }

    private static class StraightLengthCounter {
        private static final Collector<DieValue, StraightLengthCounter, StraightLengthCounter> COLLECTOR = Collector.of(
            () -> new StraightLengthCounter(),
            (straightCounter, dieValue) -> straightCounter.apply(dieValue),
            (l, r) -> {
                throw new ConcurrentModificationException("This collector can only be applied sequentially.");
            },
            straightCounter -> straightCounter,
            Collector.Characteristics.IDENTITY_FINISH
        );

        public static int calculate(Roll roll) {
            return roll.orderedStream().sequential().collect(COLLECTOR).max;
        }

        private int runningCount = 0;
        private int max = 0;
        private DieValue previousValue = DieValue.unfollowed();

        private void apply(DieValue die) {
            Objects.requireNonNull(die);
            this.runningCount = die.follows(this.previousValue) ? this.runningCount += 1 : 1;
            this.max = Math.max(this.max, this.runningCount);
            this.previousValue = die;
        }
    }
}
