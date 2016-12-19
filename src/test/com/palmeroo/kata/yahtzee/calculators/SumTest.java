package com.palmeroo.kata.yahtzee.calculators;

import com.palmeroo.kata.yahtzee.util.Roll;
import org.junit.Test;

import static com.palmeroo.kata.yahtzee.calculators.Calculator.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SumTest {
    @Test
    public void scoreAs_chance_sums_all_die() {
        assertThat(Roll.of(3, 3, 4, 5, 1).scoreAs(CHANCE), is(16));
    }

    @Test
    public void scoreAs_ones_returns_0() {
        assertThat(Roll.of(6, 2, 2, 4, 5).scoreAs(ONES), is(0));
    }

    @Test
    public void scoreAs_ones_returns_2() {
        assertThat(Roll.of(1, 2, 1, 4, 5).scoreAs(ONES), is(2));
    }

    @Test
    public void scoreAs_ones_returns_4() {
        assertThat(Roll.of(1, 2, 1, 1, 1).scoreAs(ONES), is(4));
    }

    @Test
    public void scoreAs_twos_returns_4() {
        assertThat(Roll.of(1, 2, 3, 2, 6).scoreAs(TWOS), is(4));
    }

    @Test
    public void scoreAs_twos_returns_10() {
        assertThat(Roll.of(2, 2, 2, 2, 2).scoreAs(TWOS), is(10));
    }

    @Test
    public void scoreAs_threes_returns_6() {
        assertThat(Roll.of(1, 2, 3, 2, 3).scoreAs(THREES), is(6));
    }

    @Test
    public void scoreAs_threes_returns_12() {
        assertThat(Roll.of(2, 3, 3, 3, 3).scoreAs(THREES), is(12));
    }

    @Test
    public void scoreAs_fours_returns_12() {
        assertThat(Roll.of(4, 4, 4, 5, 5).scoreAs(FOURS), is(12));
    }

    @Test
    public void scoreAs_fours_returns_4() {
        assertThat(Roll.of(4, 5, 5, 5, 5).scoreAs(FOURS), is(4));
    }

    @Test
    public void scoreAs_fives_returns_10() {
        assertThat(Roll.of(4, 4, 4, 5, 5).scoreAs(FIVES), is(10));
    }

    @Test
    public void scoreAs_fives_returns_15() {
        assertThat(Roll.of(4, 4, 5, 5, 5).scoreAs(FIVES), is(15));
    }

    @Test
    public void scoreAs_sixes_returns_0() {
        assertThat(Roll.of(4, 4, 4, 5, 5).scoreAs(SIXES), is(0));
    }

    @Test
    public void scoreAs_sixes_returns_18() {
        assertThat(Roll.of(6, 5, 6, 6, 5).scoreAs(SIXES), is(18));
    }
}
