package fsts.logic.generator.variant;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class FossilElectricGenerator extends BaseGenerator {

    private static final String NAME = "Fossil Fuel Power Plant";
    private static final BigNum BASE_COST = new BigNum(1e8);
    private static final BigNum BASE_GENERATION = new BigNum(1e7);
    private static final BigNum COST_SCALING = new BigNum(2.5);
    private static final TechTier TIER = TechTier.ELECTRICAL;

    public FossilElectricGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}