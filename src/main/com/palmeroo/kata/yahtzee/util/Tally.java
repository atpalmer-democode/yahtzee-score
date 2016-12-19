package com.palmeroo.kata.yahtzee.util;

import java.util.Objects;
import java.util.function.Predicate;

public class Tally {
    private final DieValue dieValue;
    private final int counter;

    private Tally(DieValue dieValue, int counter) {
        this.dieValue = Objects.requireNonNull(dieValue);
        this.counter = counter;
    }

    public static Tally of(DieValue dieValue) {
        return new Tally(dieValue, 1);
    }

    public static Predicate<Tally> hasCount(int n) {
        return t -> t.count() == n;
    }

    public static Predicate<Tally> hasCountOrGreater(int n) {
        return t -> t.count() >= n;
    }

    public static Predicate<Tally> all() {
        return t -> true;
    }

    public static Predicate<Tally> matches(DieValue dieValue) {
        Objects.requireNonNull(dieValue);
        return t -> t.die().equals(dieValue);
    }

    public Tally increment() {
        return new Tally(this.dieValue, counter + 1);
    }

    public DieValue die() {
        return dieValue;
    }

    public int count() {
        return counter;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tally)) {
            return false;
        }
        Tally tally = (Tally) o;
        return this.dieValue.equals(tally.dieValue)
            && this.counter == tally.counter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dieValue, counter);
    }

    @Override
    public String toString() {
        return String.format("[DieValue: %d, Count: %d]", dieValue.toInt(), counter);
    }
}
