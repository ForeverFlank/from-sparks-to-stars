package fsts.logic.generator;

import fsts.math.BigNum;

public class GeneratorState {

    public final GeneratorDefinition definition;

    private BigNum count = BigNum.ZERO;

    public GeneratorState(GeneratorDefinition definition) {
        this.definition = definition;
    }

    public BigNum getCount() {
        return count;
    }

    public void setCount(BigNum count) {
        this.count = BigNum.max(count, BigNum.ZERO);
    }

    public void addCount(BigNum count) {
        setCount(getCount().add(count));
    }

    public BigNum getCost() {
        return definition.baseCost.mul(definition.costScaling.pow(count));
    }
}