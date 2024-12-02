package com.github.d.led.paaae.drivers;

import com.github.d.led.paaae.adapters.driven.FixedMonthlyInterestRate;
import com.github.d.led.paaae.app.SimpleInterestCalculator;
import com.github.d.led.paaae.app.ports.driven.ForGettingInterestRates;
import com.github.d.led.paaae.app.ports.driving.ForCalculatingInterest;

import java.time.Period;

public class Main {
    final ForGettingInterestRates fixedInterestRate =
            new FixedMonthlyInterestRate(0.01);
    // replace ForCalculatingInterest with SimpleInterestCalculator
    // to see the ArchUnit test fail
    final ForCalculatingInterest interestCalculator =
            new SimpleInterestCalculator(fixedInterestRate);

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        System.out.println(
                interestCalculator.interestFromNow(42, Period.ofMonths(12))
        );
    }
}
