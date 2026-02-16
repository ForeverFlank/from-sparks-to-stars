package fsts.logic.generator;

import fsts.logic.tier.TechTier;
import fsts.math.BigNum;

public abstract class BaseGenerator {

    public final String name;
    public final BigNum baseCost;
    public final BigNum baseGeneration;
    public final BigNum costScaling;
    public final TechTier techTier;

    public BaseGenerator(
        String name,
        BigNum baseCost,
        BigNum baseGeneration,
        BigNum costScaling,
        TechTier techTier
    ) {
        this.name = name;
        this.baseCost = baseCost;
        this.baseGeneration = baseGeneration;
        this.costScaling = costScaling;
        this.techTier = techTier;
    }
}
