package fsts.logic.recipe;

import fsts.logic.item.Item;
import fsts.manager.Game;
import fsts.manager.item.ItemId;
import fsts.manager.item.ItemManager;
import fsts.math.BigNum;

public record RecipeInput(ItemId itemId, BigNum amount, boolean keepItem) {

    public String getItemDisplayName() {
        ItemManager itemManager = Game.getInstance().itemManager;
        Item item = itemManager.getItem(itemId);
        return item.name();
    }
}
