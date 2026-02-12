package fsts.manager;

import fsts.logic.generator.GeneratorDefinition;
import fsts.logic.generator.GeneratorState;
import fsts.logic.generator.variant.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneratorManager {

    public final List<GeneratorState> generatorStates;

    public GeneratorManager() {
        GeneratorDefinition[] generatorDefinitions = {
            new CampfireGenerator(),
            new WindmillGenerator(),
            new FossilFuelGenerator(),
            new GroundSolarGenerator(),
            new FissionGenerator(),
            new FusionGenerator(),
            new SpaceSolarGenerator(),
            new DysonSwarmGenerator(),
            new BlackHoleGenerator(),
        };
        generatorStates = Arrays.stream(generatorDefinitions)
                                .map(GeneratorState::new)
                                .collect(Collectors.toCollection(ArrayList::new));
    }
}
