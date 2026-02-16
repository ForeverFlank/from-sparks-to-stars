package fsts.logic.generator.tier4;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class GasElectricGenerator extends BaseGenerator {

    private static final String NAME = "Natural Gas Power Plant";
    private static final BigNum BASE_COST = new BigNum(1.0E9);
    private static final BigNum BASE_GENERATION = new BigNum(1.0E7);
    private static final BigNum COST_SCALING = new BigNum(2.5);
    private static final TechTier TIER = TechTier.ELECTRICAL;

    public GasElectricGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}