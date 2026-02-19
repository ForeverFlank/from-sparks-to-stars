package fsts.logic.generator.variant;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class VacuumEnergyGenerator extends BaseGenerator {

    private static final String NAME = "Vacuum Energy Extractor";
    private static final BigNum BASE_COST = new BigNum(1e30);
    private static final BigNum BASE_GENERATION = new BigNum(1e36);
    private static final BigNum COST_SCALING = new BigNum(10.0);
    private static final TechTier TIER = TechTier.COSMIC;

    public VacuumEnergyGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}