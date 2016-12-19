package com.palmeroo.kata.yahtzee.util;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class TallyTest {
    @Test
    public void die_returns_die_passed_to_creation_method() {
        Tally target = Tally.of(DieValue.ONE);
        assertThat(target.die(), is(DieValue.ONE));
    }

    @Test
    public void count_starts_at_one() {
        Tally target = Tally.of(DieValue.ONE);
        assertThat(target.count(), is(1));
    }

    @Test
    public void count_is_two_after_increment() {
        Tally target = Tally.of(DieValue.ONE).increment();
        assertThat(target.count(), is(2));
    }

    @Test
    public void tallies_are_equal_when_initialized_with_same_dieValue() {
        Tally tally1 = Tally.of(DieValue.THREE);
        Tally tally2 = Tally.of(DieValue.THREE);
        assertThat(tally2, is(equalTo(tally1)));
    }

    @Test
    public void tally_hashCode_equals_other_tally_hashCode_when_initialized_with_same_dieValue() {
        Tally tally1 = Tally.of(DieValue.THREE);
        Tally tally2 = Tally.of(DieValue.THREE);
        assertThat(tally2.hashCode(), is(tally1.hashCode()));
    }
}
