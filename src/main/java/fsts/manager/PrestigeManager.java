package fsts.manager;

import fsts.math.BigNum;

public class PrestigeManager {

    private BigNum prestige;

    public PrestigeManager() {
        prestige = BigNum.ZERO;
    }

    public BigNum getPrestige() {
        return prestige;
    }

    public void setPrestige(BigNum prestige) {
        this.prestige = BigNum.max(prestige, BigNum.ZERO);
    }

    public void addPrestige(BigNum prestige) {
        setPrestige(getPrestige().add(prestige));
    }

    public BigNum getCost() {
        return new BigNum(1e5).mul(BigNum.pow(10, prestige));
    }

    public BigNum getMaxPrestige(BigNum energy) {
        if (energy.lt(getCost())) {
            return BigNum.ZERO;
        }
        return energy.log10().floor().sub(4).sub(prestige);
    }

    public BigNum getMaxPrestigeCost(BigNum energy) {
        return new BigNum(1e5).mul(BigNum.pow(10, prestige.add(getMaxPrestige(energy))));
    }
}
