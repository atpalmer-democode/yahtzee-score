package com.palmeroo.kata.yahtzee.util;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class RollTest {
    @Test
    public void sum_all_dice() {
        int result = Roll.of(1, 2, 3, 4, 5).sum(d -> true);
        assertThat(result, is(equalTo(15)));
    }

    @Test
    public void sum_with_predicate() {
        int result = Roll.of(1, 2, 3, 4, 5).sum(t -> t.die().equals(DieValue.FOUR));
        assertThat(result, is(equalTo(4)));
    }
}
