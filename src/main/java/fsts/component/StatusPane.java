package fsts.component;

import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import fsts.manager.Game;
import fsts.manager.item.ItemId;
import fsts.math.BigNum;

public class StatusPane extends HBox {
    public final Text energyDisplay;

    public StatusPane() {
        energyDisplay = new Text("0");
        energyDisplay.setFont(new Font(18));

        getChildren().add(energyDisplay);
    }

    public void update() {
        BigNum energy = Game.getInstance().itemManager.getAmount(ItemId.ENERGY);
        energyDisplay.setText(energy.format(1, 1e6, false));
    }
}
