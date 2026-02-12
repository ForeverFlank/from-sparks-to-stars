package fsts.component;

import fsts.logic.generator.GeneratorDefinition;
import fsts.logic.generator.GeneratorState;
import fsts.manager.Game;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GeneratorButton extends HBox {

    private final Button button;

    private final GeneratorState generatorState;
    private final Label countText;

    public GeneratorButton(GeneratorState generatorState) {
        this.generatorState = generatorState;
        GeneratorDefinition definition = generatorState.definition;

        setPrefSize(250, 50);

        Label nameLabel = new Label(definition.name);
        StackPane nameContainer = new StackPane(nameLabel);

        countText = new Label("0");
        StackPane countTextContainer = new StackPane(countText);
        countTextContainer.setMinWidth(50);
        countTextContainer.setPrefWidth(50);
        countTextContainer.setAlignment(Pos.CENTER);

        button = new Button("0");
        button.setPrefSize(50, 20);
        button.setOnAction(_ -> onClick());
        StackPane buttonContainer = new StackPane(button);
        buttonContainer.setAlignment(Pos.CENTER);

        getChildren().addAll(nameContainer, countTextContainer, buttonContainer);
    }

    public void update() {
        countText.setText(generatorState.getCount().format(0, 1e6, true));
        button.setText(generatorState.getCost().format(0, 1e6, true));
    }

    private void onClick() {
        Game.getInstance().buyGenerator(generatorState);
    }
}
