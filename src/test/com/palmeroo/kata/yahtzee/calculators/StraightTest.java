package com.palmeroo.kata.yahtzee.calculators;

import com.palmeroo.kata.yahtzee.util.Roll;
import org.junit.Test;

import static com.palmeroo.kata.yahtzee.calculators.Calculator.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StraightTest {
    @Test
    public void scoreAs_smallStraight_returns_15_for_1_to_4() {
        assertThat(Roll.of(1, 2, 3, 4, 6).scoreAs(SMALL_STRAIGHT), is(15));
    }

    @Test
    public void scoreAs_smallStraight_returns_15_for_2_to_6() {
        assertThat(Roll.of(6, 3, 4, 5, 2).scoreAs(SMALL_STRAIGHT), is(15));
    }

    @Test
    public void scoreAs_smallStraight_returns_15_for_3_to_6() {
        assertThat(Roll.of(1, 3, 6, 4, 5).scoreAs(SMALL_STRAIGHT), is(15));
    }

    @Test
    public void scoreAs_smallStraight_returns_0_for_1_2_3_5_6() {
        assertThat(Roll.of(1, 3, 6, 2, 5).scoreAs(SMALL_STRAIGHT), is(0));
    }

    @Test
    public void scoreAs_largeStraight_returns_20_for_2_to_6() {
        assertThat(Roll.of(6, 2, 3, 4, 5).scoreAs(LARGE_STRAIGHT), is(20));
    }

    @Test
    public void scoreAs_largeStraight_returns_20_for_1_to_5() {
        assertThat(Roll.of(2, 3, 4, 5, 1).scoreAs(LARGE_STRAIGHT), is(20));
    }

    @Test
    public void scoreAs_largeStraight_returns_0_for_1_2_3_4_6() {
        assertThat(Roll.of(1, 2, 3, 4, 6).scoreAs(LARGE_STRAIGHT), is(0));
    }
}
