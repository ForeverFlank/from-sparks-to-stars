package fsts.logic.generator.variant;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class SolarGenerator extends BaseGenerator {

    private static final String NAME = "Photovoltaic Panel";
    private static final BigNum BASE_COST = new BigNum(1e9);
    private static final BigNum BASE_GENERATION = new BigNum(1e8);
    private static final BigNum COST_SCALING = new BigNum(3.0);
    private static final TechTier TIER = TechTier.RENEWABLE;

    public SolarGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}