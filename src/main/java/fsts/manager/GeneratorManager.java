package fsts.manager;

import fsts.logic.generator.BaseGenerator;
import fsts.logic.generator.GeneratorState;
import fsts.logic.generator.tier1.CampfireGenerator;
import fsts.logic.generator.tier1.HumanPowerGenerator;
import fsts.logic.generator.tier2.CharcoalGenerator;
import fsts.logic.generator.tier2.WatermillGenerator;
import fsts.logic.generator.tier3.CoalSteamGenerator;
import fsts.logic.generator.tier3.OilSteamGenerator;
import fsts.logic.generator.tier4.CoalElectricGenerator;
import fsts.logic.generator.tier4.GasElectricGenerator;
import fsts.logic.generator.tier5.FissionGenerator;
import fsts.logic.generator.tier5.GroundSolarGenerator;
import fsts.logic.generator.tier6.FusionGenerator;
import fsts.logic.generator.tier6.SpaceSolarGenerator;
import fsts.logic.generator.tier7.DysonSwarmGenerator;
import fsts.logic.generator.tier8.BlackHoleGenerator;
import fsts.logic.generator.tier9.VacuumEnergyGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeneratorManager {

    public final List<GeneratorState> generatorStates;

    public GeneratorManager() {
        BaseGenerator[] baseGenerators = {
            new HumanPowerGenerator(),
            new CampfireGenerator(),
            new WatermillGenerator(),
            new CharcoalGenerator(),
            new OilSteamGenerator(),
            new CoalSteamGenerator(),
            new GasElectricGenerator(),
            new CoalElectricGenerator(),
            new FissionGenerator(),
            new GroundSolarGenerator(),
            new FusionGenerator(),
            new SpaceSolarGenerator(),
            new DysonSwarmGenerator(),
            new BlackHoleGenerator(),
            new VacuumEnergyGenerator()
        };
        generatorStates = Arrays.stream(baseGenerators)
                                .map(GeneratorState::new)
                                .collect(Collectors.toCollection(ArrayList::new));
    }
}
