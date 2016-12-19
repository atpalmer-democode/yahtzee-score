package com.palmeroo.kata.yahtzee.calculators;

import com.palmeroo.kata.yahtzee.util.Roll;
import org.junit.Test;

import static com.palmeroo.kata.yahtzee.calculators.Calculator.FULL_HOUSE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FullHouseTest {
    @Test
    public void scoreAs_fullHouse_returns_25() {
        assertThat(Roll.of(6, 2, 2, 2, 6).scoreAs(FULL_HOUSE), is(25));
    }

    @Test
    public void scoreAs_fullHouse_returns_0() {
        assertThat(Roll.of(6, 6, 1, 2, 6).scoreAs(FULL_HOUSE), is(0));
    }
}
