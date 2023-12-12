package com.example.springmodulithjmolecules;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class ModulithTest {

    ApplicationModules modules = ApplicationModules.of(SpringModulithJmoleculesApplication.class);

    @Test
    void verifyModularity() {

        // --> Module model
        // System.out.println(modules.toString());

        // --> Trigger verification
        modules.verify();
    }

    @Test
    void renderDocumentation() throws Exception {

        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml()
                .writeModuleCanvases();
    }

    @Test
    void printModuleInfor() {
        modules.forEach(System.out::println);
    }
}
