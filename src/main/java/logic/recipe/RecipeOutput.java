package logic.recipe;

import logic.item.Item;
import manager.Game;
import manager.item.ItemManager;
import math.BigNum;

public class RecipeOutput {
    public final BigNum quantity;
    public final String itemName;

    public RecipeOutput(String itemName, BigNum quantity) {
        this.quantity = quantity;
        this.itemName = itemName;
    }

    public String getItemDisplayName() {
        ItemManager itemManager = Game.getInstance().itemManager;
        Item item = itemManager.itemByName.get(itemName);
        return item.displayName;
    }
}