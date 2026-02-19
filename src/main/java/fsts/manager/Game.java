package fsts.manager;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.generator.GeneratorState;
import fsts.math.BigNum;

public class Game {

    private static Game instance;

    public static double deltaTimeSeconds = 0.05;

    public final EnergyManager energyManager;
    public final GeneratorManager generatorManager;
    public final ResearchManager researchManager;
    public final PrestigeManager prestigeManager;

    public static void init() {
        instance = new Game();
    }

    public static Game getInstance() {
        return instance;
    }

    private Game() {
        energyManager = new EnergyManager();
        generatorManager = new GeneratorManager();
        researchManager = new ResearchManager();
        prestigeManager = new PrestigeManager();

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        long periodMillis = (long) (deltaTimeSeconds * 1000);
        scheduler.scheduleAtFixedRate(this::update, 0, periodMillis, TimeUnit.MILLISECONDS);
    }

    public void update() {
        BigNum addedEnergy = getFinalEnergyGeneration().mul(deltaTimeSeconds);
        energyManager.addEnergy(addedEnergy);

        BigNum addedResearchPoint = getFinalResearchPointGeneration().mul(deltaTimeSeconds);
        researchManager.addResearchPoint(addedResearchPoint);
    }

    // TODO: (..., BigNum amount) param
    public void buyGenerator(GeneratorState generatorState) {
        BigNum cost = generatorState.getCost();

        if (energyManager.hasEnoughEnergy(cost)) {
            energyManager.removeEnergy(cost);
            generatorState.addCount(BigNum.ONE);
        }
    }

    public void prestige() {
        BigNum cost = prestigeManager.getCost();

        if (energyManager.hasEnoughEnergy(cost)) {
            BigNum buyable = prestigeManager.getMaxPrestige(energyManager.getEnergy());
            prestigeManager.addPrestige(buyable);
            resetByPrestige();
        }
    }

    public void resetByPrestige() {
        energyManager.resetByPrestige();
        generatorManager.resetByPrestige();
    }

    public BigNum getTotalEnergyGeneration() {
        BigNum totalEnergy = BigNum.ZERO;

        for (GeneratorState generator : generatorManager.generatorStates) {
            BaseGenerator definition = generator.definition;
            BigNum count = generator.getCount();
            BigNum energyGenerated = definition.baseGeneration.mul(count);

            totalEnergy = totalEnergy.add(energyGenerated);
        }

        return totalEnergy.mul(getGameSpeed());
    }

    public BigNum getFinalEnergyGeneration() {
        BigNum totalEnergy = getTotalEnergyGeneration();

        return totalEnergy.mul(1.0 - researchManager.getResearchFraction());
    }

    public BigNum getFinalResearchPointGeneration() {
        BigNum totalEnergy = getTotalEnergyGeneration();
        BigNum usedEnergy = totalEnergy.mul(researchManager.getResearchFraction());

        return usedEnergy.mul(researchManager.getResearchPerEnergy());
    }

    public BigNum getGameSpeed() {
        return BigNum.pow(1.125, prestigeManager.getPrestige());
    }
}
