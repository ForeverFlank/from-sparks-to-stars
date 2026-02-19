package fsts.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.generator.GeneratorState;
import fsts.logic.generator.variant.BlackHoleGenerator;
import fsts.logic.generator.variant.CampfireGenerator;
import fsts.logic.generator.variant.CharcoalGenerator;
import fsts.logic.generator.variant.DysonSwarmGenerator;
import fsts.logic.generator.variant.FissionGenerator;
import fsts.logic.generator.variant.FossilElectricGenerator;
import fsts.logic.generator.variant.FossilSteamGenerator;
import fsts.logic.generator.variant.FusionGenerator;
import fsts.logic.generator.variant.HumanPowerGenerator;
import fsts.logic.generator.variant.SolarGenerator;
import fsts.logic.generator.variant.VacuumEnergyGenerator;
import fsts.logic.generator.variant.WatermillGenerator;
import fsts.math.BigNum;

public class GeneratorManager {

    public final List<GeneratorState> generatorStates;

    public GeneratorManager() {
        BaseGenerator[] baseGenerators = {
            new HumanPowerGenerator(),
            new CampfireGenerator(),
            new WatermillGenerator(),
            new CharcoalGenerator(),
            new FossilSteamGenerator(),
            new FossilElectricGenerator(),
            new SolarGenerator(),
            new FissionGenerator(),
            new FusionGenerator(),
            new DysonSwarmGenerator(),
            new BlackHoleGenerator(),
            new VacuumEnergyGenerator()
        };
        generatorStates = Arrays.stream(baseGenerators)
                                .map(GeneratorState::new)
                                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void resetByPrestige() {
        for (GeneratorState generator : generatorStates) {
            generator.setCount(BigNum.ZERO);
        }
    }
}
