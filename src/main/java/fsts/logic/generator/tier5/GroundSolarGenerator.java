package fsts.logic.generator.tier5;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class GroundSolarGenerator extends BaseGenerator {

    // TODO: make this incredibly cheap with research upgrades
    private static final String NAME = "Ground-Based Solar Farm";
    private static final BigNum BASE_COST = new BigNum(1.0E10);
    private static final BigNum BASE_GENERATION = new BigNum(1.0E8);
    private static final BigNum COST_SCALING = new BigNum(3);
    private static final TechTier TIER = TechTier.RENEWABLE;

    public GroundSolarGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}