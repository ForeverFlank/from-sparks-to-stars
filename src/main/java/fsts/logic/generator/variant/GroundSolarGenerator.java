package fsts.logic.generator.variant;

import fsts.logic.generator.GeneratorDefinition;
import fsts.math.BigNum;

public final class GroundSolarGenerator extends GeneratorDefinition {
    // TODO: special property: base cost gets cheaper over time!
    private static final String NAME = "Solar Farm";
    private static final BigNum BASE_COST = new BigNum(1e6);
    private static final BigNum BASE_GENERATION = new BigNum(100);
    private static final BigNum COST_SCALING = new BigNum(2.5);

    public GroundSolarGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING);
    }
}