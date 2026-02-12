package fsts.logic.generator.variant;

import fsts.logic.generator.GeneratorDefinition;
import fsts.math.BigNum;

public final class FossilFuelGenerator extends GeneratorDefinition {

    private static final String NAME = "Fossil Fuel Plant";
    private static final BigNum BASE_COST = new BigNum(1e5);
    private static final BigNum BASE_GENERATION = new BigNum(100);
    private static final BigNum COST_SCALING = new BigNum(2);

    public FossilFuelGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING);
    }
}