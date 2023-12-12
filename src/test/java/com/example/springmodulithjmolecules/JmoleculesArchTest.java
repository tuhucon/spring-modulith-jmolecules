package com.example.springmodulithjmolecules;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
import org.jmolecules.archunit.JMoleculesDddRules;
import org.junit.jupiter.api.Test;

@AnalyzeClasses(packages = "com.example.springmodulithjmolecules")
public class JmoleculesArchTest {

    @ArchTest
    ArchRule layerRule = JMoleculesArchitectureRules.ensureLayering();
//
//    @ArchTest
//    ArchRule onionRule = JMoleculesArchitectureRules.ensureOnionClassical();
//
//    @ArchTest
//    ArchRule hexagonRule = JMoleculesArchitectureRules.ensureHexagonal();

}
