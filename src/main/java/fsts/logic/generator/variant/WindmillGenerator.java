package fsts.logic.generator.variant;

import fsts.logic.generator.GeneratorDefinition;
import fsts.math.BigNum;

public final class WindmillGenerator extends GeneratorDefinition {

    private static final String NAME = "Windmill";
    private static final BigNum BASE_COST = new BigNum(1000);
    private static final BigNum BASE_GENERATION = new BigNum(20);
    private static final BigNum COST_SCALING = new BigNum(1.5);

    public WindmillGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING);
    }
}