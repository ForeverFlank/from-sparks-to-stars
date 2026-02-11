package logic.recipe;

import java.util.ArrayList;

public class Recipe {
    public final ArrayList<RecipeInput> inputs;
    public final ArrayList<RecipeOutput> outputs;

    public Recipe(ArrayList<RecipeInput> inputs, ArrayList<RecipeOutput> outputs) {
        this.inputs = inputs;
        this.outputs = outputs;
    }
}
