package fsts.manager;

import fsts.math.BigNum;

public class EnergyManager {

    private BigNum energy;
    private BigNum capacity;

    public EnergyManager() {
        energy = new BigNum(1e3);
        capacity = new BigNum(1e100);
    }

    public void resetByPrestige() {
        energy = new BigNum(1e3);
    }

    public BigNum getEnergy() {
        return energy;
    }

    public void setEnergy(BigNum value) {
        energy = BigNum.clamp(value, BigNum.ZERO, capacity);
    }

    public BigNum getCapacity() {
        return capacity;
    }

    public void setCapacity(BigNum value) {
        capacity = BigNum.max(value, BigNum.ZERO);
    }

    public void addEnergy(BigNum value) {
        setEnergy(getEnergy().add(value));
    }

    public void removeEnergy(BigNum value) {
        setEnergy(getEnergy().sub(value));
    }

    public boolean hasEnoughEnergy(BigNum value) {
        final double EPSILON = 1E-5;
        return energy.cmp(value.sub(EPSILON)) >= 0;
    }
}
