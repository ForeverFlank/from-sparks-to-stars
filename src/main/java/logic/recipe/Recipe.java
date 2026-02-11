package logic.recipe;

import math.BigNum;

import java.util.ArrayList;

public class Recipe {
    public final ArrayList<RecipeInput> inputs;
    public final ArrayList<RecipeOutput> outputs;
    public final String description;
    public final BigNum duration;
    public final boolean isAuto;

    public Recipe(
            ArrayList<RecipeInput> inputs,
            ArrayList<RecipeOutput> outputs,
            String description,
            BigNum duration,
            boolean isAuto
    ) {
        this.inputs = inputs;
        this.outputs = outputs;
        this.description = description;
        this.duration = duration;
        this.isAuto = isAuto;
    }
}
