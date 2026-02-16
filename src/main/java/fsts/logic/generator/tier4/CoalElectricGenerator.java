package fsts.logic.generator.tier4;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class CoalElectricGenerator extends BaseGenerator {

    private static final String NAME = "Coal Power Plant";
    private static final BigNum BASE_COST = new BigNum(1.0E10);
    private static final BigNum BASE_GENERATION = new BigNum(1.0E8);
    private static final BigNum COST_SCALING = new BigNum(2.5);
    private static final TechTier TIER = TechTier.ELECTRICAL;

    public CoalElectricGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}