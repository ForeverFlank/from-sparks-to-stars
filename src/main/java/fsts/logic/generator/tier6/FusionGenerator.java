package fsts.logic.generator.tier6;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class FusionGenerator extends BaseGenerator {

    private static final String NAME = "Nuclear Fusion Power Plant";
    private static final BigNum BASE_COST = new BigNum(1.0E12);
    private static final BigNum BASE_GENERATION = new BigNum(1.0E9);
    private static final BigNum COST_SCALING = new BigNum(4);
    private static final TechTier TIER = TechTier.SPACE;

    public FusionGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}