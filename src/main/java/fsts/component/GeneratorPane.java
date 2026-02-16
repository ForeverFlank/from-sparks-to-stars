package fsts.component;

import fsts.logic.generator.GeneratorState;
import fsts.logic.tier.TechTier;
import fsts.manager.Game;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class GeneratorPane extends VBox {

    private final List<GeneratorButton> generatorButtons;

    public GeneratorPane() {
        generatorButtons = new ArrayList<>();

        for (GeneratorState generator : Game.getInstance().generatorManager.generatorStates) {
            for (TechTier techTier : TechTier.values()) {
                if (generator.definition.techTier != techTier) continue;
                generatorButtons.add(new GeneratorButton(generator));
            }
        }

        getChildren().addAll(generatorButtons);
    }

    public void update() {
        for (GeneratorButton button : generatorButtons) {
            button.update();
        }
    }
}
