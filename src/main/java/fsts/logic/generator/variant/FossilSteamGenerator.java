package fsts.logic.generator.variant;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class FossilSteamGenerator extends BaseGenerator {

    private static final String NAME = "Fossil Fuel Steam Engine";
    private static final BigNum BASE_COST = new BigNum(1e7);
    private static final BigNum BASE_GENERATION = new BigNum(1e6);
    private static final BigNum COST_SCALING = new BigNum(2.0);
    private static final TechTier TIER = TechTier.INDUSTRIAL;

    public FossilSteamGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}