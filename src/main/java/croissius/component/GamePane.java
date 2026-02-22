package croissius.component;

import javafx.scene.layout.HBox;

public class GamePane extends HBox {

    private final StatusPane statusPane;
    private final ShooterPane playfieldPane;
    private final ShopPane shopPane;

    public GamePane() {
        this.statusPane = new StatusPane();
        this.playfieldPane = new ShooterPane();
        this.shopPane = new ShopPane();

        getChildren().addAll(statusPane, playfieldPane, shopPane);
    }

    public void update() {
        playfieldPane.update();
    }
}