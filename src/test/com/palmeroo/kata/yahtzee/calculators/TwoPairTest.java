package com.palmeroo.kata.yahtzee.calculators;

import com.palmeroo.kata.yahtzee.util.Roll;
import org.junit.Test;

import static com.palmeroo.kata.yahtzee.calculators.Calculator.TWO_PAIR;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TwoPairTest {
    @Test
    public void scoreAs_twoPair_returns_16_with_3_fives_and_2_threes() {
        assertThat(Roll.of(3, 3, 5, 5, 5).scoreAs(TWO_PAIR), is(16));
    }

    @Test
    public void scoreAs_twoPair_returns_0_with_one_pair() {
        assertThat(Roll.of(3, 3, 2, 4, 5).scoreAs(TWO_PAIR), is(0));
    }

    @Test
    public void scoreAs_twoPair_returns_0_with_no_pair() {
        assertThat(Roll.of(3, 1, 2, 6, 5).scoreAs(TWO_PAIR), is(0));
    }
}
