package fsts.logic.generator.variant;

import fsts.logic.generator.GeneratorDefinition;
import fsts.math.BigNum;

public final class FissionGenerator extends GeneratorDefinition {

    private static final String NAME = "Fission Reactor";
    private static final BigNum BASE_COST = new BigNum(1e8);
    private static final BigNum BASE_GENERATION = new BigNum(1000);
    private static final BigNum COST_SCALING = new BigNum(3);

    public FissionGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING);
    }
}