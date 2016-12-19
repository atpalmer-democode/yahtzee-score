package com.palmeroo.kata.yahtzee.calculators;

import com.palmeroo.kata.yahtzee.util.DieValue;
import com.palmeroo.kata.yahtzee.util.Roll;
import com.palmeroo.kata.yahtzee.util.Tally;

import java.util.List;

import static com.palmeroo.kata.yahtzee.calculators.Calculator.DEFAULT_POINTS;

class OfAKindCalculator implements RollCalculator {
    private final int ofAKind;

    private OfAKindCalculator(int ofAKind) {
        this.ofAKind = ofAKind;
    }

    public static RollCalculator ofAKind(int ofAKind) {
        return new OfAKindCalculator(ofAKind);
    }

    @Override
    public int calculate(Roll roll) {
        List<DieValue> dice = roll.where(Tally.hasCountOrGreater(this.ofAKind));
        assert dice.size() <= 2;
        return !dice.isEmpty()
            ? dice.get(0).toInt() * this.ofAKind
            : DEFAULT_POINTS;
    }
}
