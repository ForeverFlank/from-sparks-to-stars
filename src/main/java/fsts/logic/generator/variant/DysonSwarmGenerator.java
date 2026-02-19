package fsts.logic.generator.variant;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public final class DysonSwarmGenerator extends BaseGenerator {

    private static final String NAME = "Dyson Swarm";
    private static final BigNum BASE_COST = new BigNum(1e14);
    private static final BigNum BASE_GENERATION = new BigNum(1e16);
    private static final BigNum COST_SCALING = new BigNum(6.0);
    private static final TechTier TIER = TechTier.STELLAR;

    public DysonSwarmGenerator() {
        super(NAME, BASE_COST, BASE_GENERATION, COST_SCALING, TIER);
    }
}