package fsts.component;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import fsts.logic.item.Item;
import fsts.manager.Game;
import fsts.manager.item.ItemId;
import fsts.math.BigNum;

public class ItemAmountPane extends HBox {
    public final ItemId itemId;
    public final String displayName;
    public final Text amountText;

    public ItemAmountPane(ItemId itemId) {
        this.itemId = itemId;

        Item item = Game.getInstance().itemManager.getItem(itemId);
        displayName = item.name();

        Text displayNameText = new Text(displayName);
        StackPane displayNameContainer = new StackPane(displayNameText);
        displayNameContainer.setPrefWidth(150);
        displayNameContainer.setMinWidth(150);
        displayNameContainer.setAlignment(Pos.BASELINE_LEFT);

        amountText = new Text();
        amountText.setTextAlignment(TextAlignment.RIGHT);
        StackPane amountTextContainer = new StackPane(amountText);
        amountTextContainer.setAlignment(Pos.BASELINE_RIGHT);
        amountTextContainer.setPrefWidth(50);
        amountTextContainer.setMinWidth(50);

        getChildren().add(displayNameContainer);
        getChildren().add(amountTextContainer);
    }

    public void update() {
        BigNum amount = Game.getInstance().itemManager.getAmount(itemId);
        amountText.setText(amount.format(1, 1e6, true));
    }
}
