package fsts.logic.generator.variant;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class CampfireGenerator extends BaseGenerator {

    private static final String NAME = "Campfire";
    private static final BigNum BASE_COST = new BigNum(1e4);
    private static final BigNum BASE_GENERATION = new BigNum(1e3);
    private static final BigNum COST_SCALING = new BigNum(1.25);
    private static final TechTier TIER = TechTier.PRIMITIVE;

    public CampfireGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}