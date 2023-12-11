package com.example.springmodulithjmolecules;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModule;
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

        ApplicationModule common = modules.getModuleByName("common").get();
        common.getNamedInterfaces().forEach(x -> {
            System.out.println(x.toString());
        });

        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml()
                .writeModuleCanvases();
    }
}
