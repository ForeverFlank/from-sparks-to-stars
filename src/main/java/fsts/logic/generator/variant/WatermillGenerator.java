package fsts.logic.generator.variant;

import fsts.logic.generator.GeneratorDefinition;
import fsts.math.BigNum;

public final class WatermillGenerator extends GeneratorDefinition {

    private static final String NAME = "Watermill";
    private static final BigNum BASE_COST = new BigNum(200);
    private static final BigNum BASE_GENERATION = new BigNum(20);
    private static final BigNum COST_SCALING = new BigNum(1.5);

    public WatermillGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING);
    }
}