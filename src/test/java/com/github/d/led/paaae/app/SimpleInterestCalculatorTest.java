package com.github.d.led.paaae.app;

import com.github.d.led.paaae.adapters.driving.SimpleInterestCalculator;
import org.junit.jupiter.api.Test;

import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class SimpleInterestCalculatorTest {
    @Test
    void zero_interest_rate_returns_zero() {
        assertEquals(
                0L,
                new SimpleInterestCalculator(() -> 0.0)
                        .interestFromNow(100, Period.ofMonths(1))
        );
    }

    @Test
    void less_than_one_month_returns_zero() {
        assertEquals(
                0L,
                new SimpleInterestCalculator(() -> 0.1)
                        .interestFromNow(100, Period.ofDays(10))
        );
    }

    @Test
    void simple_interest_rate_is_easy() {
        assertEquals(
                12L,
                new SimpleInterestCalculator(() -> 0.01)
                        .interestFromNow(100, Period.ofMonths(12))
        );
    }

    @Test
    void full_months_are_counted() {
        assertEquals(
                1L,
                new SimpleInterestCalculator(() -> 0.01)
                        .interestFromNow(100, Period.ofDays(55))
        );
    }
}