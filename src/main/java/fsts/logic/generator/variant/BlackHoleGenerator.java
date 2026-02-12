package fsts.logic.generator.variant;

import fsts.logic.generator.GeneratorDefinition;
import fsts.math.BigNum;

public final class BlackHoleGenerator extends GeneratorDefinition {

    private static final String NAME = "Black Hole Generator";
    private static final BigNum BASE_COST = new BigNum(1e15);
    private static final BigNum BASE_GENERATION = new BigNum(1e12);
    private static final BigNum COST_SCALING = new BigNum(5);

    public BlackHoleGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING);
    }
}