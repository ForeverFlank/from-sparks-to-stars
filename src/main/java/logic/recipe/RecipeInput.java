package logic.recipe;

import logic.item.Item;
import manager.Game;
import manager.item.ItemManager;
import math.BigNum;

public class RecipeInput {
    public final BigNum quantity;
    public final String itemName;
    public final boolean keepItem;

    public RecipeInput(String itemName, BigNum quantity, boolean keepItem) {
        this.quantity = quantity;
        this.itemName = itemName;
        this.keepItem = keepItem;
    }

    public String getItemDisplayName() {
        ItemManager itemManager = Game.getInstance().itemManager;
        Item item = itemManager.itemByName.get(itemName);
        return item.displayName;
    }
}
