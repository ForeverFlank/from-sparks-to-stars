package fsts.manager;

import fsts.logic.generator.GeneratorDefinition;
import fsts.logic.generator.GeneratorState;
import fsts.math.BigNum;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game {
    private static Game instance;

    public static double deltaTimeSeconds = 0.05;

    public final EnergyManager energyManager;
    public final GeneratorManager generatorManager;
    public final TimeManager timeManager;
    // TODO: research manager: something like a slider for spending some energy into research

    public static void init() {
        instance = new Game();
    }

    public static Game getInstance() {
        return instance;
    }

    private Game() {
        energyManager = new EnergyManager();
        generatorManager = new GeneratorManager();
        timeManager = new TimeManager();

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        long periodMillis = (long) (deltaTimeSeconds * 1000);
        scheduler.scheduleAtFixedRate(this::update, 0, periodMillis, TimeUnit.MILLISECONDS);
    }

    public void update() {
        for (GeneratorState generator : generatorManager.generatorStates) {
            GeneratorDefinition definition = generator.definition;
            BigNum count = generator.getCount();
            BigNum energyGenerated = definition.baseGeneration.mul(count).mul(timeManager.getDeltaTime());
            energyManager.addEnergy(energyGenerated);
        }
    }

    // TODO: (..., BigNum amount) param
    public void buyGenerator(GeneratorState generatorState) {
        BigNum cost = generatorState.getCost();
        if (energyManager.hasEnoughEnergy(cost)) {
            energyManager.removeEnergy(cost);
            generatorState.addCount(BigNum.ONE);
        }
    }
}
