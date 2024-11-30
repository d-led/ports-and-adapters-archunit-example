package com.github.d.led.paaae.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(
        packages = "com.github.d.led.paaae",
        importOptions = {ImportOption.DoNotIncludeTests.class})
public class PortsAndAdaptersTest {
    @ArchTest
    public static ArchRule adapters_are_outside_the_app =
            // replace noClasses() with classes() to see the test fails
            noClasses().that().resideInAPackage("..adapters..")
                    .should().resideInAPackage("..app..");
}
