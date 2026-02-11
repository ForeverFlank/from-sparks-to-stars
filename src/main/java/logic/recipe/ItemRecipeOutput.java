package logic.recipe;

import math.BigNum;

public class ItemRecipeOutput extends RecipeOutput {
    public final String itemName;

    public ItemRecipeOutput(String itemName, BigNum quantity) {
        super(quantity);
        this.itemName = itemName;
    }
}
