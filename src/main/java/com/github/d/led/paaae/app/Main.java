package com.github.d.led.paaae.app;

import com.github.d.led.paaae.adapters.driven.FixedMonthlyInterestRate;
import com.github.d.led.paaae.adapters.driving.SimpleInterestCalculator;
import com.github.d.led.paaae.app.ports.driven.ForGettingInterestRates;
import com.github.d.led.paaae.app.ports.driving.ForCalculatingInterest;

import java.time.Period;

public class Main {
    public static void main(String[] args) {
        ForGettingInterestRates fixedInterestRate = new FixedMonthlyInterestRate(0.01);
        ForCalculatingInterest interestCalculator = new SimpleInterestCalculator(fixedInterestRate);
        System.out.println(
                interestCalculator.interestFromNow(42, Period.ofMonths(12))
        );
    }
}
