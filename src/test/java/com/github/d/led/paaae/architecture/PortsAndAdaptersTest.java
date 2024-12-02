package com.github.d.led.paaae.architecture;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
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
    public static final ArchRule adapters_are_outside_the_app =
            // replace noClasses() with classes() to see the test fail
            noClasses().that().resideInAPackage("..adapters..")
                    .should().resideInAPackage("..app..");

    @ArchTest
    public static final ArchRule drivers_are_outside_the_app =
            // replace noClasses() with classes() to see the test fail
            noClasses().that().resideInAPackage("..drivers..")
                    .should().resideInAPackage("..app..");

    @ArchTest
    public static final ArchRule drivers_should_only_talk_to_the_port_interfaces =
            fields().that()
                    .areDeclaredInClassesThat().resideInAPackage("..drivers..")
                    .should()
                    .haveRawType(ofAPort());

    static DescribedPredicate<JavaClass> ofAPort() {
        return new DescribedPredicate<>("that is a port") {
            @Override
            public boolean test(final JavaClass input) {
                final var classFullName = input.getFullName();
                return classFullName.contains(".ports.");
            }
        };
    }
}
