package croissius;

import java.util.HashSet;
import java.util.Set;

import croissius.component.GamePane;
import croissius.manager.GameManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    private final Set<KeyCode> pressedKeys = new HashSet<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().add("stylesheet.css");

        scene.setOnKeyPressed(event
                -> pressedKeys.add(event.getCode())
        );

        scene.setOnKeyReleased(event
                -> pressedKeys.remove(event.getCode())
        );

        GamePane gamePane = new GamePane();
        root.getChildren().add(gamePane);

        primaryStage.setTitle("From Stones to Stars");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        GameManager.initialize();
        launch(args);
    }
}
