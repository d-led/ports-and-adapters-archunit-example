package com.github.d.led.paaae.app;

import com.github.d.led.paaae.app.ports.driven.ForGettingInterestRates;
import com.github.d.led.paaae.app.ports.driving.ForCalculatingInterest;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class SimpleInterestCalculator implements ForCalculatingInterest {
    private final ForGettingInterestRates forGettingInterestRates;

    public SimpleInterestCalculator(ForGettingInterestRates forGettingInterestRates) {
        this.forGettingInterestRates = forGettingInterestRates;
    }

    @Override
    public long interestFromNow(long principal, Period period) {
        // useless demo implementation
        final LocalDateTime now = LocalDateTime.now(); // reference timestamp
        final LocalDateTime end = now.plus(period);
        final long months = ChronoUnit.MONTHS.between(now, end);
        return Math.round(
                forGettingInterestRates.monthlyInterestRate()
                        *
                        months
                        *
                        principal
        );
    }
}
