package fsts.logic.generator;

import fsts.logic.generator.variant.CampfireGenerator;
import fsts.logic.generator.variant.WatermillGenerator;

import java.util.function.Supplier;

public enum GeneratorType {

    CAMPFIRE(CampfireGenerator::new),
    WATERMILL(WatermillGenerator::new);

    private final Supplier<GeneratorDefinition> constructor;

    GeneratorType(Supplier<GeneratorDefinition> constructor) {
        this.constructor = constructor;
    }

    public GeneratorDefinition create() {
        return constructor.get();
    }
}