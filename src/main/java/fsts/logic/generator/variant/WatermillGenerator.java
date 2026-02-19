package fsts.logic.generator.variant;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class WatermillGenerator extends BaseGenerator {

    private static final String NAME = "Watermill";
    private static final BigNum BASE_COST = new BigNum(1e5);
    private static final BigNum BASE_GENERATION = new BigNum(1e4);
    private static final BigNum COST_SCALING = new BigNum(1.5);
    private static final TechTier TIER = TechTier.MEDIEVAL;

    public WatermillGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}