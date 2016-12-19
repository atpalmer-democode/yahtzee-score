package com.palmeroo.kata.yahtzee.calculators;

import com.palmeroo.kata.yahtzee.util.Roll;
import org.junit.Test;

import static com.palmeroo.kata.yahtzee.calculators.Calculator.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OfAKindTest {
    @Test
    public void scoreAs_pair_returns_6() {
        assertThat(Roll.of(3, 4, 3, 5, 6).scoreAs(Calculator.PAIR), is(6));
    }

    @Test
    public void scoreAs_pair_returns_10() {
        assertThat(Roll.of(5, 3, 3, 5, 5).scoreAs(Calculator.PAIR), is(10));
    }

    @Test
    public void scoreAs_pair_returns_0() {
        assertThat(Roll.of(5, 6, 4, 2, 1).scoreAs(Calculator.PAIR), is(0));
    }

    @Test
    public void scoreAs_threeOfAKind_returns_9() {
        assertThat(Roll.of(3, 3, 3, 3, 5).scoreAs(THREE_OF_A_KIND), is(9));
    }

    @Test
    public void scoreAs_threeOfAKind_returns_12() {
        assertThat(Roll.of(4, 4, 4, 4, 4).scoreAs(THREE_OF_A_KIND), is(12));
    }

    @Test
    public void scoreAs_threeOfAKind_returns_0() {
        assertThat(Roll.of(3, 3, 4, 4, 5).scoreAs(THREE_OF_A_KIND), is(0));
    }

    @Test
    public void scoreAs_fourOfAKind_returns_12() {
        assertThat(Roll.of(3, 3, 3, 3, 3).scoreAs(FOUR_OF_A_KIND), is(12));
    }

    @Test
    public void scoreAs_fourOfAKind_returns_0() {
        assertThat(Roll.of(5, 5, 4, 4, 5).scoreAs(FOUR_OF_A_KIND), is(0));
    }
}
