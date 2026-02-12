package fsts.logic.generator.variant;

import fsts.logic.generator.GeneratorDefinition;
import fsts.math.BigNum;

public final class FusionGenerator extends GeneratorDefinition {

    private static final String NAME = "Fusion Reactor";
    private static final BigNum BASE_COST = new BigNum(1e10);
    private static final BigNum BASE_GENERATION = new BigNum(10000);
    private static final BigNum COST_SCALING = new BigNum(3.5);

    public FusionGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING);
    }
}