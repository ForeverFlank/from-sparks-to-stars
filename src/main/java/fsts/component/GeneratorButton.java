package fsts.component;

import fsts.logic.generator.GeneratorDefinition;
import fsts.logic.generator.GeneratorState;
import fsts.manager.Game;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GeneratorButton extends Button {

    private final GeneratorState generatorState;
    private final Label countText;
    private final Label costText;

    public GeneratorButton(GeneratorState generatorState) {
        this.generatorState = generatorState;

        setPrefSize(150, 50);

        GeneratorDefinition definition = generatorState.definition;

        Label nameText = new Label(definition.name);

        countText = new Label("0");
        StackPane countTextContainer = new StackPane(countText);
        countTextContainer.setMinWidth(50);
        countTextContainer.setPrefWidth(50);
        countTextContainer.setAlignment(Pos.BASELINE_RIGHT);

        costText = new Label("0");
        StackPane costTextContainer = new StackPane(costText);
        costTextContainer.setMinWidth(50);
        costTextContainer.setPrefWidth(50);
        costTextContainer.setAlignment(Pos.BASELINE_RIGHT);

        HBox hBox = new HBox(countTextContainer, costTextContainer);
        VBox vBox = new VBox(nameText, hBox);

        setGraphic(vBox);

        setOnAction(_ -> onClick());
    }

    public void update() {
        countText.setText(generatorState.getCount().format(0, 1e6, true));
        costText.setText(generatorState.getCost().format(0, 1e6, true));
    }

    private void onClick() {
        Game.getInstance().buyGenerator(generatorState);
    }
}
