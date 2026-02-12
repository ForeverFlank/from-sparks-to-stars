package fsts.logic.generator;

import fsts.math.BigNum;

public abstract class GeneratorDefinition {

    public final String name;
    public final BigNum baseCost;
    public final BigNum baseGeneration;
    public final BigNum costScaling;

    public GeneratorDefinition(
        String name,
        BigNum baseCost,
        BigNum baseGeneration,
        BigNum costScaling
    ) {
        this.name = name;
        this.baseCost = baseCost;
        this.baseGeneration = baseGeneration;
        this.costScaling = costScaling;
    }
}
