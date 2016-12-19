package com.palmeroo.kata.yahtzee.calculators;

import com.palmeroo.kata.yahtzee.util.Roll;
import org.junit.Test;

import static com.palmeroo.kata.yahtzee.calculators.Calculator.YAHTZEE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class YahtzeeTest {
    @Test
    public void scoreAs_yahtzee_returns_50_with_5_matching_die() {
        assertThat(Roll.of(4, 4, 4, 4, 4).scoreAs(YAHTZEE), is(50));
    }

    @Test
    public void scoreAs_yahtzee_returns_0_with_4_matching_die() {
        assertThat(Roll.of(6, 6, 6, 6, 3).scoreAs(YAHTZEE), is(0));
    }
}
