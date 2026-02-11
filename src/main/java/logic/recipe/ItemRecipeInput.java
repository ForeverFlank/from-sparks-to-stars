package logic.recipe;

import math.BigNum;

public class ItemRecipeInput extends RecipeInput {
    public final String itemName;
    public final boolean keepItem;

    public ItemRecipeInput(String itemName, BigNum quantity, boolean keepItem) {
        super(quantity);
        this.itemName = itemName;
        this.keepItem = keepItem;
    }
}
