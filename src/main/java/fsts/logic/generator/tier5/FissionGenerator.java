package fsts.logic.generator.tier5;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class FissionGenerator extends BaseGenerator {

    private static final String NAME = "Nuclear Fission Power Plant";
    private static final BigNum BASE_COST = new BigNum(1.0E11);
    private static final BigNum BASE_GENERATION = new BigNum(1.0E9);
    private static final BigNum COST_SCALING = new BigNum(3);
    private static final TechTier TIER = TechTier.RENEWABLE;

    public FissionGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}