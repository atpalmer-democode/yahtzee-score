package com.palmeroo.kata.yahtzee.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DieValueTest {
    @Test
    public void of_creation_method_sets_value() {
        DieValue target = DieValue.of(4);
        assertThat(target.toInt(), is(4));
    }

    @Test
    public void one_constant_is_equal_to_dieValue_of_1() {
        assertThat(DieValue.ONE, is(equalTo(DieValue.of(1))));
    }

    @Test
    public void two_constant_is_equal_to_dieValue_of_2() {
        assertThat(DieValue.TWO, is(equalTo(DieValue.of(2))));
    }

    @Test
    public void three_constant_is_equal_to_dieValue_of_3() {
        assertThat(DieValue.THREE, is(equalTo(DieValue.of(3))));
    }

    @Test
    public void four_constant_is_equal_to_dieValue_of_4() {
        assertThat(DieValue.FOUR, is(equalTo(DieValue.of(4))));
    }

    @Test
    public void five_constant_is_equal_to_dieValue_of_5() {
        assertThat(DieValue.FIVE, is(equalTo(DieValue.of(5))));
    }

    @Test
    public void six_constant_is_equal_to_dieValue_of_6() {
        assertThat(DieValue.SIX, is(equalTo(DieValue.of(6))));
    }

    @Test
    public void four_follows_five_is_true() {
        assertThat(DieValue.FOUR.follows(DieValue.FIVE), is(true));
    }

    @Test
    public void three_follows_five_is_false() {
        assertThat(DieValue.THREE.follows(DieValue.FIVE), is(false));
    }

    @Test
    public void three_greaterThan_two() {
        assertThat(DieValue.THREE, greaterThan(DieValue.TWO));
    }

    @Test
    public void three_lessThan_four() {
        assertThat(DieValue.THREE, lessThan(DieValue.FOUR));
    }

    @Test
    public void three_comparesEqualTo_three() {
        assertThat(DieValue.THREE, comparesEqualTo(DieValue.THREE));
    }

    @Test
    public void three_not_equals_four() {
        assertThat(DieValue.THREE, is(not(equalTo(DieValue.FOUR))));
    }
}
