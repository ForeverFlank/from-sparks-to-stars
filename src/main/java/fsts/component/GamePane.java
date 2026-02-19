package fsts.component;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class GamePane extends BorderPane {

    public final StatusPane statusPane;
    public final GeneratorPane generatorPane;
    public final ResearchPane researchPane;
    public final PrestigePane prestigePane;

    public GamePane() {
        statusPane = new StatusPane();
        generatorPane = new GeneratorPane();
        researchPane = new ResearchPane();
        prestigePane = new PrestigePane();

        HBox hBox = new HBox(generatorPane, researchPane);
        VBox vBox = new VBox(hBox, prestigePane);

        setTop(statusPane);
        setCenter(vBox);

        KeyFrame keyFrame = new KeyFrame(
            Duration.seconds(0.05),
            _ -> {
                statusPane.update();
                generatorPane.update();
                prestigePane.update();
            }
        );
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
