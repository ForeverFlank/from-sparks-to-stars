package fsts.logic.generator.tier3;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class OilSteamGenerator extends BaseGenerator {

    private static final String NAME = "Oil Burner";
    private static final BigNum BASE_COST = new BigNum(5.0E6);
    private static final BigNum BASE_GENERATION = new BigNum(5.0E5);
    private static final BigNum COST_SCALING = new BigNum(2);
    private static final TechTier TIER = TechTier.INDUSTRIAL;

    public OilSteamGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}