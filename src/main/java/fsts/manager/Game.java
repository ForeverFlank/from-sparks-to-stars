package fsts.manager;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import fsts.logic.recipe.Recipe;
import fsts.logic.recipe.RecipeInput;
import fsts.logic.recipe.RecipeOutput;
import fsts.manager.item.ItemId;
import fsts.manager.item.ItemManager;
import fsts.manager.recipe.RecipeManager;
import fsts.math.BigNum;

public class Game {
    private static Game instance;

    public final ItemManager itemManager;
    public final RecipeManager recipeManager;
    public final ResearchManager researchManager;
    public final TimeManager timeManager;

    public static void init() {
        instance = new Game();
    }

    public static Game getInstance() {
        return instance;
    }

    private Game() {
        itemManager = new ItemManager();
        recipeManager = new RecipeManager();
        researchManager = new ResearchManager();
        timeManager = new TimeManager();

        itemManager.setAmount(ItemId.ENERGY, new BigNum(10));

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.05), _ -> step());
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void step() {

    }

    public boolean canUseRecipe(Recipe recipe) {
        final double EPSILON = 1E-7;
        for (RecipeInput input : recipe.inputs) {
            if (!itemManager.hasEnough(input.itemId(), input.amount(), EPSILON)) {
                return false;
            }
        }
        return true;
    }

    public boolean useRecipe(Recipe recipe) {
        if (!canUseRecipe(recipe)) return false;

        for (RecipeInput input : recipe.inputs) {
            if (input.keepItem()) continue;
            itemManager.remove(input.itemId(), input.amount());
        }

        for (RecipeOutput output : recipe.outputs) {
            itemManager.add(output.itemId(), output.amount());
        }

        return true;
    }
}
