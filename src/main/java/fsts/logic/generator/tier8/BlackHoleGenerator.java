package fsts.logic.generator.tier8;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class BlackHoleGenerator extends BaseGenerator {

    private static final String NAME = "Black Hole Generator";
    private static final BigNum BASE_COST = new BigNum(1.0E24);
    private static final BigNum BASE_GENERATION = new BigNum(1.0E30);
    private static final BigNum COST_SCALING = new BigNum(8);
    private static final TechTier TIER = TechTier.GALACTIC;

    public BlackHoleGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}