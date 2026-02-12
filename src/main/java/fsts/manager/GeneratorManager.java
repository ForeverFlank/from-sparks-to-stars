package fsts.manager;

import fsts.logic.generator.GeneratorState;
import fsts.logic.generator.GeneratorType;

import java.util.*;

public class GeneratorManager {

    public final List<GeneratorState> generatorStates =
        Arrays.stream(GeneratorType.values())
              .map(GeneratorType::create)
              .map(GeneratorState::new)
              .toList();
}
