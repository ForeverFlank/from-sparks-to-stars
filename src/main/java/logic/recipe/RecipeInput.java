package logic.recipe;

import math.BigNum;

public record RecipeInput (
        String itemName,
        BigNum amount,
        boolean keepItem) {
}
