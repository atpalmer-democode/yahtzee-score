package com.palmeroo.kata.yahtzee.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum DieValue {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private static final Map<Integer, DieValue> dieValueMap = Arrays.stream(DieValue.values())
        .collect(Collectors.toMap(x -> x.value, x -> x));

    public static DieValue of(Integer value) {
        return dieValueMap.get(value);
    }

    public static DieValue unfollowed() {
        return ONE;
    }

    private final int value;

    DieValue(int value) {
        this.value = value;
    }

    public int toInt() {
        return value;
    }

    public boolean follows(DieValue die) {
        Objects.requireNonNull(die);
        return this.value == die.value - 1;
    }
}
