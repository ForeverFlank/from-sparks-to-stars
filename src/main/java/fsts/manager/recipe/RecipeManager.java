package fsts.manager.recipe;

import fsts.logic.recipe.Recipe;
import fsts.util.ResourceUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

// TODO: recipe id
// TODO: recipe cooldown
// TODO: make all recipes use energy

public class RecipeManager {
    public final ArrayList<Recipe> recipes;

    public RecipeManager() {
        recipes = new ArrayList<>();
        loadAllRecipes();
    }

    private void loadAllRecipes() {
        Map<String, InputStream> inputStreams = ResourceUtils.loadResourceFiles("recipes");

        for (InputStream stream : inputStreams.values()) {
            ArrayList<Recipe> parsedRecipes = RecipeParser.parseRecipes(stream);
            recipes.addAll(parsedRecipes);
        }
    }
}
