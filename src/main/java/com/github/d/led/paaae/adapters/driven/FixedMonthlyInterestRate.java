package com.github.d.led.paaae.adapters.driven;

import com.github.d.led.paaae.app.ports.driven.ForGettingInterestRates;

public class FixedMonthlyInterestRate implements ForGettingInterestRates {
    private final double rate;

    public FixedMonthlyInterestRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double monthlyInterestRate() {
        return rate;
    }
}
