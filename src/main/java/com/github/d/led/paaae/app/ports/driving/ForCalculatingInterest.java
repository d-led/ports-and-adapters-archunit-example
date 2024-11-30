package com.github.d.led.paaae.app.ports.driving;

import java.time.Period;

public interface ForCalculatingInterest {
    long interestFromNow(long principal, Period time);
}
