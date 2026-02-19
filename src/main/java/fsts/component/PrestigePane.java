package fsts.component;

import fsts.manager.Game;
import fsts.math.BigNum;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class PrestigePane extends HBox {

    private final Text prestigeText;
    private final Button prestigeButton;

    public PrestigePane() {
        prestigeText = new Text("Civillization Reset");
        prestigeButton = new Button();
        prestigeButton.setOnAction(_ -> onPrestigeButtonClick());

        getChildren().addAll(prestigeText, prestigeButton);
    }

    private void onPrestigeButtonClick() {
        Game.getInstance().prestige();
    }

    public void update() {
        BigNum singlePrestigeCost = Game.getInstance().prestigeManager.getCost();
        BigNum totalPrestigeCost = Game.getInstance().prestigeManager.getCost();
        boolean canPrestige = Game.getInstance().energyManager.hasEnoughEnergy(singlePrestigeCost);

        prestigeButton.setText(totalPrestigeCost.format(0, 1e6, true));
        prestigeButton.setDisable(!canPrestige);
    }
}
