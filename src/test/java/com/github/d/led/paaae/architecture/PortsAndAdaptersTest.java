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
    public static final ArchRule configurator_fields_should_not_be_concrete =
            noFields().that()
                    .areDeclaredInClassesThat().resideInAPackage("..app..")
                    .should()
                    .haveRawType(ofConcreteAdapter());

    static DescribedPredicate<JavaClass> ofConcreteAdapter() {
        return new DescribedPredicate<>("that is a concrete adapter") {
            @Override
            public boolean test(final JavaClass input) {
                return input.getFullName().contains(".adapters.");
            }
        };
    }
}
