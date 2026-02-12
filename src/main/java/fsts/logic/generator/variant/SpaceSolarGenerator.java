package fsts.logic.generator.variant;

import fsts.logic.generator.GeneratorDefinition;
import fsts.math.BigNum;

public final class SpaceSolarGenerator extends GeneratorDefinition {

    private static final String NAME = "Space Solar Farm";
    private static final BigNum BASE_COST = new BigNum(1e12);
    private static final BigNum BASE_GENERATION = new BigNum(1e5);
    private static final BigNum COST_SCALING = new BigNum(4);

    public SpaceSolarGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING);
    }
}