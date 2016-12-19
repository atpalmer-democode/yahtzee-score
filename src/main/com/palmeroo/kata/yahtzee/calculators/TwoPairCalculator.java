package com.palmeroo.kata.yahtzee.calculators;

import com.palmeroo.kata.yahtzee.util.DieValue;
import com.palmeroo.kata.yahtzee.util.Roll;
import com.palmeroo.kata.yahtzee.util.Tally;

import java.util.List;
import java.util.Objects;

import static com.palmeroo.kata.yahtzee.calculators.Calculator.DEFAULT_POINTS;

class TwoPairCalculator implements RollCalculator {
    private static final int OF_A_KIND = 2;

    private TwoPairCalculator() {
    }

    public static RollCalculator create() {
        return new TwoPairCalculator();
    }

    @Override
    public int calculate(Roll roll) {
        Objects.requireNonNull(roll);
        List<DieValue> pairedDice = roll.where(Tally.hasCountOrGreater(2));

        if (pairedDice.size() < 2) {
            return DEFAULT_POINTS;
        }

        int bestDie = pairedDice.get(0).toInt();
        int nextBestDie = pairedDice.get(1).toInt();

        return (bestDie + nextBestDie) * OF_A_KIND;
    }
}
